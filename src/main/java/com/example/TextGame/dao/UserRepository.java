package com.example.TextGame.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class UserRepository {

    @Autowired
    private EvidenceRepository evidenceRepository;

        public String getQuetionStatus(int questionNumber){
            return "";
        }

        public void setQuestionStatusToAnswered(int questionNumber){
        }

        public String getEvidenceStatus(String evidence) throws IOException {
            String[] allEvidence = evidenceRepository.getEvidenceFromFile();
            if(evidence.equals(allEvidence[0])){
                return "found";
            }
            if(evidence.equals(allEvidence[1])){
                return "";
            }
            if(evidence.isEmpty()){
                return "found";
            }
            return "found";
        }
}
