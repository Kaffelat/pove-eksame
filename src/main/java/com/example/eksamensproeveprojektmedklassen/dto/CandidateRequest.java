package com.example.eksamensproeveprojektmedklassen.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequest {

    private long id;

    private String firstName;

    private String lastName;

    private long partyId;
}
