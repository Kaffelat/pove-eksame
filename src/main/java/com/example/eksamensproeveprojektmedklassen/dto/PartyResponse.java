package com.example.eksamensproeveprojektmedklassen.dto;

import com.example.eksamensproeveprojektmedklassen.entities.Candidate;
import com.example.eksamensproeveprojektmedklassen.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PartyResponse {
    private String partyName;
    private Set<Candidate> Candidates;

    public PartyResponse(Party party){
        this.partyName = party.getPartyName();
        this.Candidates = party.getPartyCandidates();
    }
}
