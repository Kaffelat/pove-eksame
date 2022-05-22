package com.example.eksamensproeveprojektmedklassen.services;

import com.example.eksamensproeveprojektmedklassen.dto.CandidateRequest;
import com.example.eksamensproeveprojektmedklassen.dto.CandidateResponse;
import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.error.NotFoundException;
import com.example.eksamensproeveprojektmedklassen.repositories.CandidateRepository;
import com.example.eksamensproeveprojektmedklassen.repositories.PartyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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
    public List<CandidateResponse> getCandidates(){
        List<Candidate> candidates = candidateRepository.findAll();
        return CandidateResponse.getCandidatesFromEntites(candidates);
    }
    public CandidateResponse getCandidate(long id){
        Candidate candidate = candidateRepository.findById(id).orElseThrow(()-> new NotFoundException("Kunne ikke finde en kandidat med dette id"));
        return new CandidateResponse(candidate);
    }
    public CandidateResponse editCandidate(CandidateRequest body ,long id){
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new NotFoundException("Kunne ikke rette den ønskede kandidat på grund af forkert id"));
        candidate.setFirstName(body.getFirstName());
        candidate.setFirstName(body.getLastName());
        //if(body.getPartyId() > 0) candidate.setParty(partyRepository.getReferenceById(body.getPartyId()));
        return new CandidateResponse(candidateRepository.save(candidate));
    }
    public void deleteCandidate(long id){
        candidateRepository.deleteById(id);
    }
}
