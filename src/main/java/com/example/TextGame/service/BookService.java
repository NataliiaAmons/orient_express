package com.example.TextGame.service;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.EvidenceRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Evidence;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
        // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // String username = CurrentSessionService.getUsername(request);
        ArrayList<Evidence> bookEvidence = new ArrayList<>();
        ArrayList<Integer> foundEvidence = userRepository.getFoundEvidence(username);
        for(int i=0; i<foundEvidence.size(); i++){
            Evidence evidence = evidenceRepository.getItemFromFile(foundEvidence.get(i), "evidences.csv");
            bookEvidence.add(evidence);

        }
        return bookEvidence;

    }


}