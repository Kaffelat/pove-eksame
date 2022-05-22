package com.example.eksamensproeveprojektmedklassen.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData {
}
