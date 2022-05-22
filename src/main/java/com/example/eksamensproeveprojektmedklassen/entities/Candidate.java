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

    private String firstName;

    private String lastName;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @ManyToOne
    private Party party;

    public Candidate(String firstName, String lastName, Party party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
    }

    public Candidate(CandidateRequest body){
        this.id = body.getId();
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();

    }
}
