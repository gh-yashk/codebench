package com.example.rce.service;

import org.springframework.stereotype.Service;

import com.example.rce.dto.TestcaseRequest;
import com.example.rce.model.Problem;
import com.example.rce.model.Testcase;
import com.example.rce.repository.ProblemRepository;
import com.example.rce.repository.TestcaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestcaseService {

    private final TestcaseRepository testcaseRepository;
    private final ProblemRepository problemRepository;

    public Testcase addTestcase(TestcaseRequest request) {
        if (testcaseRepository.existsByProblemIdAndIndex(request.problemId(), request.index())) {
            throw new RuntimeException("Testcase with same index already exists for this problem.");
        }

        Problem problem = problemRepository.findById(request.problemId())
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        Testcase testcase = new Testcase();
        testcase.setProblem(problem);
        testcase.setIndex(request.index());
        testcase.setInput(request.input());
        testcase.setOutput(request.output());

        return testcaseRepository.save(testcase);
    }
}
