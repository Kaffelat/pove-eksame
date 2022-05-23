package com.example.eksamensproeveprojektmedklassen.configuration;

import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.entities.Party;
import com.example.eksamensproeveprojektmedklassen.repositories.CandidateRepository;
import com.example.eksamensproeveprojektmedklassen.repositories.PartyRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {


    CandidateRepository candidateRepository;
    PartyRepository partyRepository;

    public MakeTestData(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public void makePartiesWithCandidates(){
        Party party1 = new Party("Socialdemokratiet","A");
        Party party2 = new Party("Det konservative Folkeparti","C");
        Party party3 = new Party("Dansk Folkeparti","O");
        Party party4 = new Party("Venstre","V");

        Candidate candidate1 = new Candidate("Marcel Meijer");
        Candidate candidate2 = new Candidate("Michael Kristensen");
        Candidate candidate3 = new Candidate("Helle Kristensen");
        Candidate candidate4 = new Candidate("Peter Kristensen");
        Candidate candidate5 = new Candidate("Louise Kristensen");
        Candidate candidate6 = new Candidate("Per Kristensen");
        Candidate candidate7 = new Candidate("Søren Kristensen");
        Candidate candidate8 = new Candidate("Anja Kristensen");

        candidateRepository.save(candidate1);

        party1.addCandidates(Set.of(candidate1,candidate2,candidate3));
        party2.addCandidates(Set.of(candidate4,candidate5));
        party3.addCandidates(Set.of(candidate6));
        party4.addCandidates(Set.of(candidate7,candidate8));


        partyRepository.saveAll(List.of(
                party1,
                party2,
                party3,
                party4));
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        makePartiesWithCandidates();
    }
}

