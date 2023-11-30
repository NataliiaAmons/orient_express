package com.example.TextGame.dao;

import com.example.TextGame.domain.Conclusion;
import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Repository
public class ConclusionRepository {

    public Conclusion getConclusionFromFile(int number) throws IOException { 
        Conclusion conclusion = new Conclusion();
        Resource resource = new ClassPathResource("static/conclusions.csv");
        File file = resource.getFile();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception except) {
            except.printStackTrace();
        }

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            if (Integer.valueOf(data[0]) == number) {
                conclusion.setNumber(Integer.valueOf(data[0]));
                conclusion.setName(data[1]);
                conclusion.setText(data[2]);
            }
        }
        try {
            reader.close();
        }
        catch (IOException except) {}
        return conclusion;
    }

    public ArrayList<Conclusion> getAllConclusion() throws IOException {
        ArrayList<Conclusion> allConclusion = new ArrayList<>();
        int num = 1;
        while (true) {
            Conclusion conclusion = getConclusionFromFile(num);
            if (conclusion.getNumber() != num) {
                break;
            }
            else {
                allConclusion.add(conclusion);
                num++;
            }
        }
        return allConclusion;
    }  
}