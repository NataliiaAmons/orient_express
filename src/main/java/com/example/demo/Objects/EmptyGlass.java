package com.example.demo.Objects;

import java.util.List;
import java.util.Scanner;

import com.example.demo.Event;
import com.example.demo.Object;


public class EmptyGlass extends Object {

    public EmptyGlass() {
        super("Empty glass", "(Glass description)");
    }
    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to examine the glass? (Y/N)");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            Event examGlass = new Event("Examining glass", "Glass is currently empty but appears to have been filled with liquid some time before. Gladly, you have sufficient skills to know it was sleep aid.");
            history.add(examGlass);
            System.out.println(examGlass.getDescription());
        }
    }
}