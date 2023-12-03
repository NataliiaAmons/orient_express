package com.TextGame.domain;

public class Location {


    private String name;
    private int number;
    private int previous;
    private String text;


    public Location(int number, int previous, String name, String text){
        this.number = number;
        this.previous = previous;
        this.name = name;
        this.text = text;

    }

    public int getPrevious() {
        return previous;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
