package com.example.eksamensproeveprojektmedklassen.services;

import com.example.eksamensproeveprojektmedklassen.dto.CandidateRequest;
import com.example.eksamensproeveprojektmedklassen.dto.CandidateResponse;
import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.error.CandidateNotFoundException;
import com.example.eksamensproeveprojektmedklassen.repositories.CandidateRepository;
import com.example.eksamensproeveprojektmedklassen.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;

    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository){
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public CandidateResponse addCandidate(CandidateRequest body){
        Candidate newCandidate = new Candidate(body);
        candidateRepository.save(newCandidate);
        return new CandidateResponse(newCandidate);
    }

    /*public List<CandidateResponse> getCandidates(){
        List<Candidate> candidates = candidateRepository.findAll();
        return CandidateResponse.getCandidatesFromEntites(candidates);
    }*/

    //Tilføjes/ændres i service klassen

    public List<CandidateResponse> getAllCandidates(String letter) {
        List<Candidate> candidates;
        if (letter != null) {
            candidates = candidateRepository.findCandidateByParty_PartyLetter(letter);
        } else {
            candidates = candidateRepository.findAll();
        }
        return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());

    }

        public CandidateResponse getCandidate(long id){
        Candidate candidate = candidateRepository.findById(id).orElseThrow(()-> new CandidateNotFoundException(id));
        return new CandidateResponse(candidate);
    }

    public CandidateResponse editCandidate(CandidateRequest body ,long id){
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
        candidate.setName(body.getName());
        return new CandidateResponse(candidateRepository.save(candidate));
    }

    public void deleteCandidate(long id){
        candidateRepository.deleteById(id);
    }
}
