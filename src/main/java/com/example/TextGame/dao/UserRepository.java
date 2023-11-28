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
            return "";
        }
}
