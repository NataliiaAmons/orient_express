package com.example.demo.Objects;

import java.util.List;
import java.util.Scanner;

import com.example.demo.Event;
import com.example.demo.Object;


public class Brush extends Object {

    public Brush() {
        super("Brush for cleaning smoking pipe", "(Brush description)");
    }
    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to examine the brush? (Y/N)");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            Event examBrush = new Event("Examining cleaning brush", "Brush description.");
            history.add(examBrush);
            System.out.println(examBrush.getDescription());
        }
    }
}