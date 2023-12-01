package com.example.TextGame.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SaveService {

    public void save(List<String> foundEvidences, String userLogin, String filename) {
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/" + filename + ".txt";
        Path path = Paths.get(filePath);

        try {
            Files.write(path, foundEvidences);
            System.out.println("File saved successfully at: " + filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}