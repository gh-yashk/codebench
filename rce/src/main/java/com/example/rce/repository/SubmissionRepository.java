package com.example.rce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rce.model.Submission;
import com.example.rce.model.SubmissionId;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    // ✅ Check if user has an Accepted (solved) submission for the problem
    boolean existsByIdUserIdAndIdProblemIdAndVerdict(Long userId, Long problemId, String verdict);

    // ✅ Check if user has made any submission for the problem (attempted)
    boolean existsByIdUserIdAndIdProblemId(Long userId, Long problemId);
}
