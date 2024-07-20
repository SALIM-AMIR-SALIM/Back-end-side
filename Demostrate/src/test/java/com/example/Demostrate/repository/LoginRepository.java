package com.example.Demostrate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demostrate.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);

}


