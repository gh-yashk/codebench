package com.example.rce.dto;

import lombok.Data;

@Data
public class CodeExecutionRequest {

    private Long problemId;
    private Long languageId;
    private String userCode;

}
