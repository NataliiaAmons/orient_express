package com.TextGame.domain;

public interface Clue {

    void setNumber(int number);
    void setName(String name);
    void setDescription(String description);

    int getNumber();
    String getName();
    String getDescription();
}