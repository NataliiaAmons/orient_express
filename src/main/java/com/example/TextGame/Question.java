package com.example.TextGame;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Question {
    private int character;
    private int number;
    private String evidenceNeeded;
    private String questionText;
    private String answer;
    private int previous;

    // getters
    public int getCharacter(){
        return character;
    }
    public int getNumber(){
        return number;
    }
    public String getEvidenceNeeded() {
        return evidenceNeeded;
    }
    public String getQuestionText(){
        return questionText;
    }
    public String getAnswer(){
        return answer;
    }
    public int getPrevious(){
        return previous;
    }

    // setters
    public void setCharacter(int name){
        this.character = name;
    }
    public void setNumber(int x){
        this.number = x;
    }
    public void setEvidenceNeeded(String evidenceNeeded) {
        this.evidenceNeeded = evidenceNeeded;
    }
    public void setQuestionText(String t){
        this.questionText = t;
    }
    public void setAnswer(String a){
        this.answer = a;
    }
    public void setPrevious(int p){
        this.previous = p;
    }

    // get questions: their numbers, text, answers, character, previous question (qestion after which they appear)
    // in file data is written like:
    // character number; number; question text; answer; previos number (0 if none)
    public Question[] getQuestionsFromFile() throws IOException {
        Resource resource = new ClassPathResource("static/questions.txt");
        File file = resource.getFile();
        BufferedReader reader = null;
        String line = "";

        ArrayList<Question> questions = new ArrayList<Question>();

        int i = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                Question question = new Question();
                question.setCharacter(Integer.valueOf(row[0]));
                question.setNumber(Integer.valueOf(row[1]));
                question.setEvidenceNeeded(row[2]);
                question.setQuestionText(row[3]);
                question.setAnswer(row[4]);
                question.setPrevious(Integer.valueOf(row[5]));

                questions.add(question);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {}
        }
        return questions.toArray(new Question[0]);
    }
}
