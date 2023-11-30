package com.example.TextGame.domain;

import com.example.TextGame.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Character {

    @Autowired
    private QuestionRepository questionRepository;
    private int number;
    private String name;
    private String photo;
    private String info;
    private ArrayList<Question> questions = new ArrayList<Question>();
    public Character(){}

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


}
