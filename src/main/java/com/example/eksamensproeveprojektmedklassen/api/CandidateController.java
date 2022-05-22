package com.example.eksamensproeveprojektmedklassen.api;

import com.example.eksamensproeveprojektmedklassen.dto.CandidateRequest;
import com.example.eksamensproeveprojektmedklassen.dto.CandidateResponse;
import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Candidates")
public class CandidateController {
    CandidateService candidateService;
    public CandidateController (CandidateService candidateService){
        this.candidateService = candidateService;
    }
    @PostMapping
    public ResponseEntity<CandidateResponse> addCandidate(@RequestBody CandidateRequest body){
        return ResponseEntity.ok(candidateService.addCandidate(body));
    }
    @GetMapping
    public List<CandidateResponse> getCandidates(){
        return candidateService.getCandidates();
    }
}
