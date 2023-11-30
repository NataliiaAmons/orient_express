package com.example.TextGame.domain;

import jakarta.validation.constraints.NotNull;

public class User {
    private Long id;
    @NotNull(message = "Поле не може бути пустим")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
