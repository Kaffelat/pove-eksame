package com.example.eksamensproeveprojektmedklassen.entities;

import com.example.eksamensproeveprojektmedklassen.dto.CandidateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String partyLetter;

    @ManyToOne(fetch = FetchType.EAGER)
    private Party party;

    public Candidate(String name) {
        this.name = name;

    }

    public Candidate(CandidateRequest body){
        this.name = body.getName();
        this.partyLetter = body.getPartyLetter();
    }
}
