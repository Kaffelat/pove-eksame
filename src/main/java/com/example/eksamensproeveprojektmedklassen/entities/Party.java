package com.example.eksamensproeveprojektmedklassen.entities;

import com.example.eksamensproeveprojektmedklassen.dto.PartyRequest;
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

    @OneToMany(mappedBy = "party")
    private Set<Candidate> partyCandidates = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Party(String partyName) {
        this.partyName = partyName;
    }
    public Party(PartyRequest body){
        this.id = body.getId();
        this.partyName = body.getPartyName();
    }
}
