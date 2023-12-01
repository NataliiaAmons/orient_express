package com.example.TextGame.viewmodel;

import com.example.TextGame.domain.Question;

public class QuestionVM {

    private int character;
    private int number;
    private int evidenceNeeded;
    private int evidenceGiven;
    private String questionText;
    private String answer;
    private int previous;
    private boolean asked;

    public QuestionVM(Question question, boolean asked){
        this.character = question.getCharacter();
        this.number = question.getNumber();
        this.evidenceNeeded = question.getEvidenceNeeded();
        this.questionText = question.getQuestionText();
        this.answer = question.getAnswer();
        this.previous = question.getPrevious();
        this.asked = asked;
    }


    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEvidenceNeeded() {
        return evidenceNeeded;
    }

    public void setEvidenceNeeded(int evidenceNeeded) {
        this.evidenceNeeded = evidenceNeeded;
    }

    public int getEvidenceGiven() {
        return evidenceGiven;
    }

    public void setEvidenceGiven(int evidenceGiven) {
        this.evidenceGiven = evidenceGiven;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}
