package com.TextGame.service;

import com.TextGame.domain.Evidence;
import com.TextGame.dao.EvidenceRepository;
import com.TextGame.dao.UserRepository;
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

