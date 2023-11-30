package com.example.TextGame.domain;

public class Evidence {

    private int number;
    private String name;
    private String photo;
    private String description;
    private String location;
    private String status;

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}