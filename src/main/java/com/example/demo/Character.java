package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character {

    Scanner scanner = new Scanner(System.in);

    // Name
    private String name;
    public String getName() {
        return name;
    }

    // Description
    private String description;
    public String getDescription() {
        return description;
    }

    // Constructor
    public Character(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // History connection
    public boolean historyConnection(List<Event> history, String prerequisiteName, String reaction, Event consequence) {
        if (history.stream().anyMatch(element -> element.getName().equals(prerequisiteName))) {
            System.out.println(reaction);
            history.add(consequence);
            return true;
        }
        else {
            return false;
        }
    }

    // Event getter
    public List<Event> characterEvents = new ArrayList<>();
    public Event getEvent(String eventName) {
        for (Event event : characterEvents) {
            if (event.getName().equals(eventName)) {
                return event;
            }
        }
        return null;
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