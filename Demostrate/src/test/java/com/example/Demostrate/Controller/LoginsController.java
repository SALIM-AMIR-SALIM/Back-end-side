package com.example.Demostrate.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demostrate.model.Login; // Make sure this import is correct based on your package structure
import com.example.Demostrate.repository.LoginRepository; // Make sure this import is correct based on your package structure

@RestController
@RequestMapping("/api/v1")
public class LoginsController {

    private final LoginRepository loginRepository;

    public LoginsController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/logins")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginRepository.findAll();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @GetMapping("/logins/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id) {
        Optional<Login> login = loginRepository.findById(id);
        return login.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
