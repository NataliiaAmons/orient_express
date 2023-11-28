package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CharactersInfo {
    private int number;
    private String name;
    private String photo;
    private String info;
    private ArrayList<Question> questions = new ArrayList<Question>();
    public CharactersInfo(){}

    // getters
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getPhoto(){
        return photo;
    }
    public String getInfo(){
        return info;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // setters
    public void setNumber(int x){
        this.number = x;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setPhoto(String ph){
        this.photo = ph; }
    public void setInfo(String i){
        this. info = i;
    }
    public void setQuestions(Question[]  allQuestions) {
        for(int j=0; j<allQuestions.length; j++){
            if(this.number == allQuestions[j].getCharacter()){
                this.questions.add(allQuestions[j]);
            }
        }
    }

    // get characters: their number, name, info, questions you can ask them (class Question)
    // in file data is written like:
    // number; name; photo; info
    // you can get questions from another file with Question().getQuestionsFromFile() method
     public CharactersInfo[] getCharactersFromFile() throws IOException {
        Resource resource = new ClassPathResource("static/char.txt");
        File file = resource.getFile();
        BufferedReader reader = null;
        String line = "";

        CharactersInfo character1 = new CharactersInfo();
        CharactersInfo character2 = new CharactersInfo();
        CharactersInfo character3 = new CharactersInfo();
        CharactersInfo character4 = new CharactersInfo();
        CharactersInfo character5 = new CharactersInfo();
        CharactersInfo character6 = new CharactersInfo();
        CharactersInfo character7 = new CharactersInfo();
        CharactersInfo character8 = new CharactersInfo();

        Question[] questions = new Question().getQuestionsFromFile();

        CharactersInfo[] characters = {character1, character2, character3, character4, character5, character6, character7, character8};
        int i = 0;

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                characters[i].setNumber(Integer.valueOf(row[0]));
                characters[i].setName(row[1]);
                characters[i].setPhoto(row[2]);
                characters[i].setInfo(row[3]);
                characters[i].setQuestions(questions);

                i++;
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
        return characters;
    }
}