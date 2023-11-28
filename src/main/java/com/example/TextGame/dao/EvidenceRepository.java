package com.example.TextGame.dao;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;

@Repository
public class EvidenceRepository extends FileRepository{


    public String[] getEvidenceFromFile() throws IOException {
        String[] evidence = new String[0];
        BufferedReader reader = super.getDataFromFile("static/evidence.csv");
        String line = "";
        while ((line = reader.readLine()) != null){
            evidence = line.split(";");
            }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return evidence;
    }

}
