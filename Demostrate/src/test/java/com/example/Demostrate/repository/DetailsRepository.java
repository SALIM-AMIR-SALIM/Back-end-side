package com.example.Demostrate.repository;

import com.example.model.Details;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
    List<Details> findByFirstName(String firstName);

}
