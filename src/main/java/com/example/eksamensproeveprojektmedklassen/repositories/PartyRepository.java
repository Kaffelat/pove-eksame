package com.example.eksamensproeveprojektmedklassen.repositories;

import com.example.eksamensproeveprojektmedklassen.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

}
