package com.example.demo;

import java.util.List;
import java.util.Scanner;

public class Object {

    Scanner scanner = new Scanner(System.in);
    
    // Name
    private String name;
    public String getName() {
        return name;
    }

    // Decription
    private String description;
    public String getDescription() {
        return description;
    }

    // Constructor
    public Object(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // History connection
    public boolean historyConnection(List<Event> history, String prerequisiteName, String reaction, Event consequence) {
        if (history.stream().anyMatch(e -> e.getName().equals(prerequisiteName))) {
            System.out.println(reaction);
            history.add(consequence);
            return true;
        }
        else {
            return false;
        }
    }

    // Interaction
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to interact with " + getName() + "?");
        String option = scanner.next();
        if (option.equals("Y")) {
            Event event = new Event(name, description);
            history.add(event);
            System.out.println(getDescription());
        }
    }
}