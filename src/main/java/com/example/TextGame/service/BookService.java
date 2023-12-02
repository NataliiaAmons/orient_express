package com.example.TextGame.service;

import com.example.TextGame.dao.EvidenceRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Evidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class BookService {
    @Autowired
    private EvidenceRepository evidenceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrentSessionService currentSessionService;



    public ArrayList<Evidence> getFoundEvidence(String username) throws IOException {
        ArrayList<Evidence> bookEvidence = new ArrayList<>();
        ArrayList<Integer> foundEvidence = userRepository.getFoundEvidence(username);
        for(int i=0; i<foundEvidence.size(); i++){
            Evidence evidence = evidenceRepository.getEvidenceFromFile(foundEvidence.get(i));
            bookEvidence.add(evidence);

        }
        return bookEvidence;

    }


}

