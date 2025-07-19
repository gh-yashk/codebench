package com.example.rce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestcaseResult {

    private String input;
    private String expectedOutput;
    private String actualOutput;
    private String status;
    private String result; // pass or fail
    private String errorMessage;

}
