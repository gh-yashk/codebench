package com.example.rce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeExecutionResult {

    private Integer nTestcases;
    private String overallResult; // "pass" or "fail"
    private List<TestcaseResult> testcases;

}
