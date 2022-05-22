package com.example.eksamensproeveprojektmedklassen.repositories;

import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
