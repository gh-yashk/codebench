package com.example.rce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rce.dto.ProblemDetail;
import com.example.rce.dto.ProblemSummary;
import com.example.rce.model.Problem;
import com.example.rce.repository.ProblemRepository;
import com.example.rce.repository.SubmissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final SubmissionRepository submissionRepository;

    public List<ProblemSummary> getAllProblems(Long userId) {
        if (userId != null) {
            return problemRepository.findAllProblemSummariesWithUserStatus(userId);
        }
        return problemRepository.findAllProblemSummaries();
    }

    public ProblemDetail getProblemDetails(String slug, Long userId) {
        Problem problem = problemRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Problem not found with slug: " + slug));

        Boolean solved = false;
        Boolean attempted = false;

        if (userId != null) {
            solved = submissionRepository.existsByIdUserIdAndIdProblemIdAndVerdict(userId, problem.getId(), "Accepted");
            attempted = submissionRepository.existsByIdUserIdAndIdProblemId(userId, problem.getId());
        }

        return new ProblemDetail(
                problem.getId(),
                problem.getTitle(),
                problem.getSlug(),
                problem.getDescription(),
                problem.getDifficulty(),
                solved,
                attempted);
    }

    public Problem addProblem(Problem problem) {
        return problemRepository.save(problem);
    }

}
