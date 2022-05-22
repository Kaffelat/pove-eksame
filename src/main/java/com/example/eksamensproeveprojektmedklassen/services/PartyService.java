package com.example.eksamensproeveprojektmedklassen.services;

import com.example.eksamensproeveprojektmedklassen.repositories.PartyRepository;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
    }

}
