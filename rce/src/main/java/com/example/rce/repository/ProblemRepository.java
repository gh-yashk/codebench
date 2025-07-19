package com.example.rce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.rce.dto.ProblemSummary;
import com.example.rce.model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    @Query("SELECT new com.example.rce.dto.ProblemSummary(p.id, p.title, p.slug, p.difficulty, false, false) FROM Problem p")
    List<ProblemSummary> findAllProblemSummaries();

    @Query("""
                SELECT new com.example.rce.dto.ProblemSummary(
                    p.id,
                    p.title,
                    p.slug,
                    p.difficulty,
                    CASE WHEN EXISTS (
                        SELECT 1 FROM Submission s
                        WHERE s.id.user.id = :userId
                          AND s.id.problem.id = p.id
                          AND s.verdict = 'Accepted'
                    ) THEN true ELSE false END,
                    CASE WHEN EXISTS (
                        SELECT 1 FROM Submission s
                        WHERE s.id.user.id = :userId
                          AND s.id.problem.id = p.id
                    ) THEN true ELSE false END
                )
                FROM Problem p
            """)
    List<ProblemSummary> findAllProblemSummariesWithUserStatus(@Param("userId") Long userId);

    Optional<Problem> findBySlug(String slug);

}
