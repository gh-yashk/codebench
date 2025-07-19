package com.example.rce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rce.model.Testcase;

public interface TestcaseRepository extends JpaRepository<Testcase, Long> {

    boolean existsByProblemIdAndIndex(Long problemId, Integer index);

    List<Testcase> findAllByProblemIdOrderByIndexAsc(Long problemId);

}
