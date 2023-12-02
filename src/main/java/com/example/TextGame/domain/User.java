package com.example.TextGame.domain;

import java.io.IOException;
import java.util.ArrayList;

public class User {

    private String login;
    private String[] questionsAsked;
    private String[] evidenceFound;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}