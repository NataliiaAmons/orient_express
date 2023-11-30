package com.example.TextGame.dao;

import com.example.TextGame.domain.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class QuestionRepository {

    public ArrayList<Question> getAllQuestions() throws IOException {
        ArrayList<Question> allQuestions = new ArrayList<>();
        int i = 1;
        while (true) {
            Question question = getQuestionFromFile(i);
            if(question.getCharacter() == 0){
                break;
            }
            allQuestions.add(question);
            i++;
        }
        return allQuestions;
    }

    public Question getQuestionFromFile(int questionNumber) throws IOException {
        Question question= new Question();

        Resource resource = new ClassPathResource("static/questions.csv");
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
            if (Integer.valueOf(row[1]) == questionNumber) {
                question.setCharacter(Integer.valueOf(row[0]));
                question.setNumber(Integer.valueOf(row[1]));
                question.setEvidenceNeeded(row[2]);
                question.setQuestionText(row[3]);
                question.setAnswer(row[4]);
                question.setPrevious(Integer.valueOf(row[5]));
            }
        }
        try {
            reader.close();
        }
        catch (IOException e) {}
        return question;
    }


}
