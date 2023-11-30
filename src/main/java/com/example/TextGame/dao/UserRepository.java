package com.example.TextGame.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.TextGame.domain.Evidence;

import java.io.IOException;

import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    private EvidenceRepository evidenceRepository;

    private ArrayList<Evidence> allEvidences;
    public UserRepository() throws IOException {
        this.allEvidences = evidenceRepository.getAllEvidences();
    }

    public String getQuetionStatus(int questionNumber){
        return "";
    }

    public void setQuestionStatusToAnswered(int questionNumber){
    }

    public void setEvidenceStatus(String name) {
        for (Evidence evidence : allEvidences) {
            if (evidence.getName().equals(name)) {
                evidence.setStatus("found");
                break;
            }
        }
    }

    public String getEvidenceStatus(String evidenceNeeded) throws IOException {
        for (Evidence evidence: allEvidences) {
            if (evidence.getName().equals(evidenceNeeded)) {
                return evidence.getStatus();
            }
        }
        return "";
    }
}