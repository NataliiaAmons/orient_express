package com.example.demo.Objects;

import java.util.List;
import java.util.Scanner;

import com.example.demo.Event;
import com.example.demo.Object;


public class BurnedLetter extends Object {

    public BurnedLetter() {
        super("Burned pieces of paper", "(Letter description)");
    }
    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to examine paper pieces? (Y/N)");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            Event examLetter = new Event("Examining burned paper", "Letter description.");
            history.add(examLetter);
            System.out.println(examLetter.getDescription());
        }
    }
}