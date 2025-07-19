package com.example.rce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarterCodeResponse {

    private Long problemId;
    private Long languageId;
    private String starterCode;

}
