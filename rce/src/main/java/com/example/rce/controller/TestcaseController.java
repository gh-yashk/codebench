package com.example.rce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rce.dto.TestcaseRequest;
import com.example.rce.model.Testcase;
import com.example.rce.service.TestcaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestcaseController {

    private final TestcaseService testcaseService;

    @PostMapping
    public ResponseEntity<Testcase> addTestcase(@RequestBody TestcaseRequest request) {
        Testcase saved = testcaseService.addTestcase(request);
        return ResponseEntity.ok(saved);
    }

}
