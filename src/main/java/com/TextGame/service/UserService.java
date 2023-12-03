package com.TextGame.service;

import com.TextGame.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public void createUserFiles(String username) throws IOException {
        userRepository.createUserFiles(username);
    }

    public void checkIfUsernameIsAvailable(String username) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<String[]> askedQuestions = new ArrayList<>();

        Resource resource = new ClassPathResource(evidence_path);
        File file = resource.getFile();
    }

}
