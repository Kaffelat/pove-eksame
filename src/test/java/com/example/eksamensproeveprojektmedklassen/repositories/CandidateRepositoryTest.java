package com.example.eksamensproeveprojektmedklassen.repositories;

import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.entities.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJdbcTest   //IMPORTANT
class CandidateRepositoryTest {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @BeforeEach
    void setUp(){
        Party party1 = new Party("Socialdemokratiet","A");
        Candidate candidate1 = new Candidate("Marcel Meijer");
        Candidate candidate2 = new Candidate("Michael Kristensen");

        party1.addCandidate(candidate1);
        party1.addCandidate(candidate2);
        partyRepository.save(party1);
    }

    @Test
    public void getCandidates(){
        List<Candidate> candidates = candidateRepository.findAll();
        assertEquals(2, candidates.size());
    }

    @Test
    public void getCandidatesFromPartiesOK(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_PartyLetter("A");
        assertEquals(2, candidates.size());
    }

    @Test
    public void getCandidatesFromPartiesNotOk(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_PartyLetter("C");
        assertEquals(0, candidates.size());
    }
}