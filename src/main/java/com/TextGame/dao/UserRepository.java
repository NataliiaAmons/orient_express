package com.TextGame.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    private EvidenceRepository evidenceRepository;

    private Path workingDir = Path.of("", "src/main/resources/users/");

    public boolean isCreated(String username) throws IOException {
        Path evidence_path = this.workingDir.resolve(username + "evidence.csv");
        boolean evidence = Files.exists(evidence_path);
        Path questions_path = this.workingDir.resolve(username + "questions.csv");
        boolean questions = Files.exists(questions_path);
        if(evidence==true && questions==true){
            return true;
        }
        else{return true;}
    }

    public void createUserFiles(String username) throws IOException {

        String evidence_path = "src/main/resources/users/" + username + "evidence.csv";
        File evidenceFile = new File(evidence_path);
        evidenceFile.createNewFile();

        String questions_path = "src/main/resources/users/" + username + "questions.csv";
        File questionsFile = new File(questions_path);
        questionsFile.createNewFile();

    }



    public ArrayList<Integer> getFoundEvidence(String username) throws IOException {
        ArrayList<Integer> foundEvidence = new ArrayList<>();

        Path questions_path = this.workingDir.resolve(username + "evidence.csv");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            for(int i=0; i<row.length; i++){
                foundEvidence.add(Integer.valueOf(row[i]));
            }
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return foundEvidence;

    }

    public void addEvidenceToFound(String username, int evidenceNumber) throws IOException {
        ArrayList<Integer> found_evidence = getFoundEvidence(username);
        if(!found_evidence.contains(evidenceNumber)) {
            found_evidence.add(evidenceNumber);

            Path evidence_path = this.workingDir.resolve(username + "evidence.csv");
            BufferedWriter writer = null;
            try {
                writer = Files.newBufferedWriter(evidence_path);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String line = String.valueOf(found_evidence.get(0));
            for (int i = 1; i < found_evidence.size(); i++) {
                line += ";" + found_evidence.get(i);
            }
            writer.write(line);
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }



    public ArrayList<Integer> getAskedQuestions(String username) throws IOException {
        ArrayList<Integer> askedQuestions = new ArrayList<>();

        Path evidence_path = this.workingDir.resolve(username + "questions.csv");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            askedQuestions.add(Integer.valueOf(row[0]));
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return askedQuestions;
    }

    public ArrayList<String[]> getAskedQuestionsWithData(String username) throws IOException {
        ArrayList<String[]> askedQuestions = new ArrayList<>();

        Path questions_path = this.workingDir.resolve(username + "questions.csv");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(questions_path);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] question = new String[2];
        String line = "";
        while ((line = reader.readLine()) != null){
            String[] row = line.split(";");
            askedQuestions.add(row);
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return askedQuestions;
    }



    public void addQuestionToAsked(String username, int questionNumber) throws IOException {
        ArrayList<String[]> askedQuestions = getAskedQuestionsWithData(username);

        Path questions_path = this.workingDir.resolve(username + "questions.csv");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String line = "";
        for (int i = 0; i < askedQuestions.size(); i++) {
            String str = askedQuestions.get(i)[0];
            if (questionNumber != Integer.valueOf(askedQuestions.get(i)[0])){
                line += askedQuestions.get(i)[0] + ";" + askedQuestions.get(i)[1] + "\n";
            }
        }
        String str = String.valueOf(questionNumber);
        line += String.valueOf(questionNumber) + ";" + String.valueOf(LocalDateTime.now());

        writer.write(line);
        try {
            reader.close();
            writer.close();
        }
        catch (IOException e) {}

    }


}
