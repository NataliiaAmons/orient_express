package com.example.TextGame.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    private EvidenceRepository evidenceRepository;

    public void createUserFiles(String username) throws IOException {

        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        File evidenceFile = new File(evidence_path);
        evidenceFile.createNewFile();

        String questions_path = "src/main/resources/static/users/" + username + "questions.csv";
        File questionsFile = new File(questions_path);
        questionsFile.createNewFile();

    }

    public ArrayList<Integer> getFoundEvidence(String username) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<Integer> foundEvidence = new ArrayList<>();

        Resource resource = new ClassPathResource(evidence_path);
        File file = resource.getFile();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            for(int i=0; i<row.length; i++){
                foundEvidence.add(Integer.valueOf(i));
            }
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return foundEvidence;

    }

    public ArrayList<Integer> getAskedQuestions(String username) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<Integer> askedQuestions = new ArrayList<>();

        Resource resource = new ClassPathResource(evidence_path);
        File file = resource.getFile();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            askedQuestions.add(Integer.valueOf(0));
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return askedQuestions;
    }

    public ArrayList<String[]> getAskedQuestionsWithData(String username) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<String[]> askedQuestions = new ArrayList<>();

        Resource resource = new ClassPathResource(evidence_path);
        File file = resource.getFile();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] question = new String[2];
        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            question[0] = row[0];
            question[1] = row[1];
            askedQuestions.add(question);
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return askedQuestions;
    }

    public void addEvidenceToFound(String username, int evidenceNumber) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<Integer> foundEvidence = new ArrayList<>();

        Resource resource = new ClassPathResource(evidence_path);
        BufferedReader reader = null;
        try {
            File file = resource.getFile();
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        BufferedWriter writer = null;
        try {
            FileWriter file = new FileWriter(evidence_path);
            writer = new BufferedWriter(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = reader.readLine();
        writer.write(line+";"+String.valueOf(evidenceNumber));
        try {
            reader.close();
            writer.close();
        }
        catch (IOException e) {}

    }

    public void addQuestionToAsked(String username, int questionNumber) throws IOException {
        String evidence_path = "src/main/resources/static/users/" + username + "evidence.csv";
        ArrayList<String[]> askedQuestions = getAskedQuestionsWithData(username);

        Resource resource = new ClassPathResource(evidence_path);
        BufferedReader reader = null;
        try {
            File file = resource.getFile();
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        BufferedWriter writer = null;
        try {
            FileWriter file = new FileWriter(evidence_path);
            writer = new BufferedWriter(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = reader.readLine();
        for (int i=0; i<askedQuestions.size(); i++){
            writer.write(askedQuestions.get(i)[0]+";"+askedQuestions.get(i)[0]);
            writer.newLine();
        }
        LocalDateTime data = LocalDateTime.now();
        writer.write(questionNumber+";"+String.valueOf(data));
        try {
            reader.close();
            writer.close();
        }
        catch (IOException e) {}

    }


}
