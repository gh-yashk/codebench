package com.example.rce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rce.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
