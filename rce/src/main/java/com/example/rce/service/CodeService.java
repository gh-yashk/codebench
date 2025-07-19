package com.example.rce.service;

import org.springframework.stereotype.Service;

import com.example.rce.dto.CodeExecutionRequest;
import com.example.rce.dto.CodeExecutionResult;
import com.example.rce.model.Code;
import com.example.rce.model.CodeId;
import com.example.rce.model.Language;
import com.example.rce.model.Problem;
import com.example.rce.model.Submission;
import com.example.rce.model.SubmissionId;
import com.example.rce.model.User;
import com.example.rce.repository.CodeRepository;
import com.example.rce.repository.LanguageRepository;
import com.example.rce.repository.ProblemRepository;
import com.example.rce.repository.SubmissionRepository;
import com.example.rce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;
    private final ProblemRepository problemRepository;
    private final LanguageRepository languageRepository;
    private final CodeExecutionService codeExecutionService;
    private final UserRepository userRepository;
    private final SubmissionRepository submissionRepository;

    public String getStarterCode(Long problemId, Long languageId) {
        CodeId codeId = new CodeId(
                problemRepository.findById(problemId)
                        .orElseThrow(() -> new RuntimeException("Problem not found")),
                languageRepository.findById(languageId)
                        .orElseThrow(() -> new RuntimeException("Language not found")));

        return codeRepository.findById(codeId)
                .map(Code::getStarterCode)
                .orElseThrow(() -> new RuntimeException("Code not found"));
    }

    public CodeExecutionResult runCode(CodeExecutionRequest request) {
        return codeExecutionService.runCode(
                request.getProblemId(),
                request.getLanguageId(),
                request.getUserCode());
    }

    public CodeExecutionResult submitCode(CodeExecutionRequest request, Long githubUserId) {
        CodeExecutionResult result = runCode(request);
        User user = userRepository.findById(githubUserId)
                .orElseThrow(() -> new RuntimeException(
                        "User not found with GitHub ID: " + githubUserId));

        Problem problem = problemRepository.findById(request.getProblemId())
                .orElseThrow(() -> new RuntimeException(
                        "Problem not found with ID: " + request.getProblemId()));

        Language language = languageRepository.findById(request.getLanguageId())
                .orElseThrow(() -> new RuntimeException(
                        "Language not found with ID: " + request.getLanguageId()));
        String verdict = result.getOverallResult().equalsIgnoreCase("pass") ? "Accepted" : "Rejected";

        SubmissionId submissionId = new SubmissionId(user, problem, language);
        Submission submission = new Submission(submissionId, request.getUserCode(), verdict);
        submissionRepository.save(submission);

        return result;
    }

    public Code addCode(Code code) {
        // Defensive: make sure problem and language are managed entities
        Problem problem = problemRepository.findById(code.getId().getProblem().getId())
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        Language language = languageRepository.findById(code.getId().getLanguage().getId())
                .orElseThrow(() -> new RuntimeException("Language not found"));

        code.getId().setProblem(problem);
        code.getId().setLanguage(language);

        return codeRepository.save(code);
    }

}
