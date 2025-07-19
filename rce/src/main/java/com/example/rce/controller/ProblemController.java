package com.example.rce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rce.dto.ProblemDetail;
import com.example.rce.dto.ProblemSummary;
import com.example.rce.model.Problem;
import com.example.rce.service.ProblemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping
    public ResponseEntity<List<ProblemSummary>> getAllProblems(@AuthenticationPrincipal OAuth2User user) {
        Long githubId = null;
        if (user != null) {
            Number githubIdRaw = user.getAttribute("id");
            githubId = githubIdRaw != null ? githubIdRaw.longValue() : null;
        }
        return ResponseEntity.ok(problemService.getAllProblems(githubId));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ProblemDetail> getProblem(
            @PathVariable String slug,
            @AuthenticationPrincipal OAuth2User user) {
        Long githubId = null;
        if (user != null) {
            Number githubIdRaw = user.getAttribute("id");
            githubId = githubIdRaw != null ? githubIdRaw.longValue() : null;
        }
        return ResponseEntity.ok(problemService.getProblemDetails(slug, githubId));
    }

    @PostMapping()
    public ResponseEntity<Problem> addProblem(@RequestBody Problem problem) {
        return ResponseEntity.ok(problemService.addProblem(problem));
    }

}
