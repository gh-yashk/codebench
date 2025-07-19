package com.example.rce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rce.dto.CodeExecutionRequest;
import com.example.rce.dto.CodeExecutionResult;
import com.example.rce.dto.StarterCodeResponse;
import com.example.rce.model.Code;
import com.example.rce.service.CodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/codes")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    // GET ?problemId=1&languageId=71
    @GetMapping
    public ResponseEntity<StarterCodeResponse> getStarterCode(
            @RequestParam Long problemId,
            @RequestParam Long languageId) {
        String starterCode = codeService.getStarterCode(problemId, languageId);
        return ResponseEntity.ok(new StarterCodeResponse(problemId, languageId, starterCode));
    }

    @PostMapping("/run")
    public ResponseEntity<CodeExecutionResult> runCode(@RequestBody CodeExecutionRequest request) {
        CodeExecutionResult result = codeService.runCode(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/submit")
    public ResponseEntity<CodeExecutionResult> submitCode(
            @RequestBody CodeExecutionRequest request,
            @AuthenticationPrincipal OAuth2User user) {
        Number githubIdRaw = user.getAttribute("id");
        Long githubId = githubIdRaw != null ? githubIdRaw.longValue() : null;
        CodeExecutionResult result = codeService.submitCode(request, githubId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Code> addCode(@RequestBody Code code) {
        Code saved = codeService.addCode(code);
        return ResponseEntity.ok(saved);
    }

}
