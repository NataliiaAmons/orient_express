package com.example.TextGame.domain;

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


}
