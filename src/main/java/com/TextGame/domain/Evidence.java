package com.TextGame.domain;

public class Evidence implements Clue {

    private int number;
    private String name;
    private String photo;
    private String description;
    private String location;

    // Setters
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation (String location) {
        this.location = location;
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

    public String getPhoto() {
        return photo;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

   }