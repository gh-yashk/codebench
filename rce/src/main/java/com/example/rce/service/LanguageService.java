package com.example.rce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rce.model.Language;
import com.example.rce.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }

}
