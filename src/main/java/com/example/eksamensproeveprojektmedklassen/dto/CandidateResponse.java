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
    private String name;
    private String partyLetter;

    public CandidateResponse(Candidate candidate) {
        this.id = candidate.getId();
        this.name = candidate.getName();
        //this.partyLetter = candidate.getParty().getPartyLetter();
    }

}
