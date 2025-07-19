package com.example.rce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rce.model.Language;
import com.example.rce.service.LanguageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @PostMapping
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        return ResponseEntity.ok(languageService.addLanguage(language));
    }

}
