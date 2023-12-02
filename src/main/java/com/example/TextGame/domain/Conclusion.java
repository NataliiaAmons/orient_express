package com.example.TextGame.domain;

public class Conclusion implements Clue {

    private int number;
    private String name;
    private String description;

    // Setters
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }


    // Getters
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}