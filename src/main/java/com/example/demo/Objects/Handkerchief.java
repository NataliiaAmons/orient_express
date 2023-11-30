package com.example.demo.Objects;

import java.util.List;
import java.util.Scanner;

import com.example.demo.Event;
import com.example.demo.Object;


public class Handkerchief extends Object {

    public Handkerchief() {
        super("Finely made handkerchief", "(Handkerchief description)");
    }
    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to examine handkerchief? (Y/N)");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            Event examHandkerchief = new Event("Examining handkerchief", "Handkerchief description.");
            history.add(examHandkerchief);
            System.out.println(examHandkerchief.getDescription());
        }
    }
}