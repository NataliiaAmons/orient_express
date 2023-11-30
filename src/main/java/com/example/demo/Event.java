package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class Event {

    // Inner class representing events
    private String name;
    public String getName() {
        return name;
    }

    private String description;
    public String getDescription() {
        return description;
    }

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }   

    // Method to create a list of events in Main class
    public static List<Event> history() {
        List<Event> pastEvents = new ArrayList<>();
        pastEvents.add(new Event("Start", "Beginning of the Game"));
        return pastEvents;
    }
}