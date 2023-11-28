package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Location {

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
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Handling characters
    private List<Character> characters = new ArrayList<>();
    public void addCharacter(Character character) {
        characters.add(character);
    }
    public String displayCharacters() {
        StringBuilder result = new StringBuilder();
        for (Character character : characters) {
            result.append("- ").append(character.getName()).append("\n");
        }
        return result.toString();
    }

    // Handling object
    private List<Object> objects = new ArrayList<>();  
    public void addObject(Object object) {
        objects.add(object);
    }
    public String displayObject() {
        StringBuilder result = new StringBuilder();
        for (Object object : objects) {
            result.append("- ").append(object.getName()).append("\n");
        }
        return result.toString();
    }

    // Points of interest
    public void pointOfInterest(List<Event> history) {
        System.out.println(getDescription());
        System.out.print("Here you can see\n" + displayCharacters() + displayObject());

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What captured your interest? (Enter the name to proceed)");

        String entityName = scanner.nextLine();

        // Check if the entity is a Character
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(entityName)) {
                character.interact(history);  // You may want to define the interact method in the Character class
                scanner.close();
                return;
            }
        }

        // Check if the entity is an Object
        for (Object object : objects) {
            if (object.getName().equalsIgnoreCase(entityName)) {
                object.interact(history);  // You may want to define the interact method in the Object class
                scanner.close();
                return;
            }
        }
    scanner.close();
    }
}