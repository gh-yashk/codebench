package com.example.rce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
