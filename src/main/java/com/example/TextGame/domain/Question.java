package com.example.TextGame.domain;

public class Question {
    private int character;
    private int number;
    private int evidenceNeeded;
    private int evidenceGiven;
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
    public int getEvidenceNeeded() {
        return evidenceNeeded;
    }
    public int getEvidenceGiven() {
        return evidenceGiven;
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
    public void setEvidenceNeeded(int evidenceNeeded) {
        this.evidenceNeeded = evidenceNeeded;
    }
    public void setEvidenceGiven(int evidenceGiven) {
        this.evidenceGiven = evidenceGiven;
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
