package com.example.TextGame.domain;

import java.io.IOException;
import java.util.ArrayList;

import com.example.TextGame.dao.EvidenceRepository;

public class User {

    private String login;
    private String[] questionsAsked;
    private String[] evidenceFound;

    public void evidenceFound() throws IOException {
        EvidenceRepository evidenceRepository = new EvidenceRepository();
        ArrayList<Evidence> allEvidences = evidenceRepository.getAllEvidences();
        ArrayList<String> evidenceFound = new ArrayList<>();

        for (Evidence evidence : allEvidences) {
            if ("found".equals(evidence.getStatus())) {
                    evidenceFound.add(evidence.getName());
            }
        }
        this.evidenceFound = evidenceFound.toArray(new String[0]);
    }
}