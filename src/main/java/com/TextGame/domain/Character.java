package com.TextGame.domain;

import com.TextGame.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Character {

    @Autowired
    private QuestionRepository questionRepository;
    private int number;
    private String name;
    private String photo;
    private String info;
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



}
