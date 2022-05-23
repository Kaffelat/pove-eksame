package com.example.eksamensproeveprojektmedklassen.entities;

import com.example.eksamensproeveprojektmedklassen.dto.PartyRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partyName;
    private String partyLetter;

    @JsonIgnore
    @OneToMany(mappedBy = "party", fetch = FetchType.EAGER)
    private Set<Candidate> partyCandidates = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Party(String partyName, String partyLetter) {
        this.partyName = partyName;
        this.partyLetter = partyLetter;
    }

//Metoder fra Mark som blev lagt op i klassen. Grunden til metoderne ligger her er for at det altid bliver gjort for begge entiteter så det forminsker fejl ved at glemme at sætte det i begge ender
    public void addCandidate(Candidate candidate){
        this.partyCandidates.add(candidate);
        candidate.setParty(this);
    }

    public void addCandidates(Set<Candidate> candidates){
        this.partyCandidates.addAll(candidates);
        for (Candidate candidate : candidates) {
            candidate.setParty(this);
        }
    }

}
