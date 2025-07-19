package com.example.rce.dto;

public record ProblemSummary(
        Long id,
        String title,
        String slug,
        String difficulty,
        Boolean solved,
        Boolean attempted) {

}
