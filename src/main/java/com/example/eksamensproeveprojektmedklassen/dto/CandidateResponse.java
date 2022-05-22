package com.example.eksamensproeveprojektmedklassen.dto;

import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateResponse {
    private long id;
    private String firstName;
    private String lastName;

    private long partyId;

    public CandidateResponse(Candidate candidate) {
        this.id = candidate.getId();
        this.firstName = candidate.getFirstName();
        this.lastName = candidate.getLastName();
        //this.partyId = candidate.getParty().getId();
    }

    public static List<CandidateResponse> getCandidatesFromEntites(List<Candidate> candidates) {
        return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());
    }
}
