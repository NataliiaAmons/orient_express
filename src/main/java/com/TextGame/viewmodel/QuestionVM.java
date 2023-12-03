package com.TextGame.viewmodel;

import com.TextGame.domain.Question;

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
        this.evidenceGiven = question.getEvidenceGiven();
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

    public int getEvidenceGiven() {
        return evidenceGiven;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPrevious() {
        return previous;
    }

    public boolean isAsked() {
        return asked;
    }

}
