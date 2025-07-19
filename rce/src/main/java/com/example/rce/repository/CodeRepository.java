package com.example.rce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rce.model.Code;
import com.example.rce.model.CodeId;

public interface CodeRepository extends JpaRepository<Code, CodeId> {

}
