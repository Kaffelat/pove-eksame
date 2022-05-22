package com.example.eksamensproeveprojektmedklassen.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CandidateNotFoundException extends ResponseStatusException {

    private static final String message = "Person with id/username '%s' not found";

    public CandidateNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format(message, id));
    }

}
