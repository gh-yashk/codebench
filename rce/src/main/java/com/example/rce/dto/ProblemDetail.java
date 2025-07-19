package com.example.rce.dto;

public record ProblemDetail(
        Long id,
        String title,
        String slug,
        String description,
        String difficulty,
        boolean solved,
        boolean attempted) {

}
