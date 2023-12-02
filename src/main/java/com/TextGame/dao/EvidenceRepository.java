package com.TextGame.dao;

import com.TextGame.domain.Evidence;
import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Repository
public class EvidenceRepository {

    public Evidence getEvidenceFromFile(int number) throws IOException {

        Evidence evidence = new Evidence();
        Resource resource = new ClassPathResource("static/evidence.csv");
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
                evidence.setNumber(Integer.valueOf(data[0]));
                evidence.setName(data[1]);
                if ("null".equals(data[2])) {
                    evidence.setPhoto(null);
                }
                else {
                    evidence.setPhoto(data[2]);
                }

                evidence.setDescription(data[3]);
                evidence.setLocation(data[4]);
            }
        }
        try {
            reader.close();
        }
        catch (IOException except) {}
        return evidence;
    }

    public ArrayList<Evidence> getAllEvidences() throws IOException {
        ArrayList<Evidence> allEvidences = new ArrayList<>();
        int num = 1;
        while (true) {
            Evidence evidence = getEvidenceFromFile(num);
            if (evidence.getNumber() != num) {
                break;
            }
            else {//possible delete
                allEvidences.add(evidence);
                num++;
            }
        }
        return allEvidences;
    }
}