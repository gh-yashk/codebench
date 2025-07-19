package com.example.rce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.rce.dto.CodeExecutionResult;
import com.example.rce.dto.Judge0SubmissionRequest;
import com.example.rce.dto.TestcaseResult;
import com.example.rce.model.Code;
import com.example.rce.model.CodeId;
import com.example.rce.model.Language;
import com.example.rce.model.Problem;
import com.example.rce.model.Testcase;
import com.example.rce.repository.CodeRepository;
import com.example.rce.repository.TestcaseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeExecutionService {

    private static final String JUDGE0_URL = "https://judge0-ce.p.rapidapi.com/submissions/?base64_encoded=false&wait=true";

    @Value("${judge0.api.key}")
    private String apiKey;

    private final CodeRepository codeRepository;
    private final TestcaseRepository testcaseRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public CodeExecutionResult runCode(Long problemId, Long languageId, String userCode) {
        log.info("Running code for problemId={}, languageId={}", problemId, languageId);

        CodeId codeId = new CodeId(new Problem(problemId), new Language(languageId));

        Code code = codeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Code not found for given problem and language"));

        String finalCode = "prepend".equalsIgnoreCase(code.getMode())
                ? code.getWrapper() + "\n" + userCode
                : userCode + "\n" + code.getWrapper();

        log.debug("Final composed code for Judge0:\n{}", finalCode);

        List<Testcase> testcases = testcaseRepository.findAllByProblemIdOrderByIndexAsc(problemId);
        List<TestcaseResult> testcaseResults = new ArrayList<>();
        boolean allPassed = true;

        for (Testcase tc : testcases) {
            log.debug("Evaluating testcase index {}", tc.getIndex());

            Judge0SubmissionRequest request = new Judge0SubmissionRequest(
                    languageId.intValue(),
                    finalCode,
                    tc.getInput(),
                    tc.getOutput());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-RapidAPI-Key", apiKey);
            headers.set("X-RapidAPI-Host", "judge0-ce.p.rapidapi.com");

            HttpEntity<Judge0SubmissionRequest> requestEntity = new HttpEntity<>(request, headers);

            try {
                ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                        JUDGE0_URL,
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });

                Map<String, Object> responseBody = response.getBody();
                if (responseBody == null) {
                    throw new RuntimeException("Empty response from Judge0 API");
                }

                String stdout = (String) responseBody.get("stdout");
                Map<?, ?> statusMap = (Map<?, ?>) responseBody.get("status");
                String status = statusMap != null ? (String) statusMap.get("description") : "Unknown";

                boolean passed = "Accepted".equalsIgnoreCase(status)
                        && stdout != null
                        && stdout.strip().equals(tc.getOutput().strip());

                if (!passed) {
                    allPassed = false;
                }

                testcaseResults.add(new TestcaseResult(
                        tc.getInput(),
                        tc.getOutput(),
                        stdout,
                        status,
                        passed ? "pass" : "fail",
                        null));
            } catch (Exception e) {
                log.error("Error while executing testcase index {}: {}", tc.getIndex(), e.getMessage());

                allPassed = false;
                testcaseResults.add(new TestcaseResult(
                        tc.getInput(),
                        tc.getOutput(),
                        null,
                        "Error",
                        "fail",
                        e.getMessage()));
            }
        }

        CodeExecutionResult result = new CodeExecutionResult(
                testcases.size(),
                allPassed ? "pass" : "fail",
                testcaseResults);

        log.info("Execution complete: {}/{} passed",
                testcaseResults.stream().filter(r -> "pass".equals(r.getResult())).count(), testcases.size());

        return result;
    }

}
