package com.example.demo.Characters;

import java.util.List;
import java.util.Scanner;

import com.example.demo.Character;
import com.example.demo.Event;

public class CarolineHubbard extends Character {

    public CarolineHubbard() {
        super("Caroline Hubbard", "Caroline description)");
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Hector about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

    //    Event findMurderWeapon = new Event("Find dagger", "You found a dagger in the Caroline's purse.");
    //    characterEvents.add(findMurderWeapon);

        Event talkAboutHandkerchief = new Event("Talk about fine handkerchief", "You talked to Caroline about handkerchief you found.");
        characterEvents.add(talkAboutHandkerchief);

    //    Event findButton = new Event("Find button", "Caroline found a button near the magazine.");
    //    characterEvents.add(findButton);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void interact(List<Event> history) {
        System.out.println(getDescription());
        System.out.println("Do you want to investigate Ms. Hubbard's purse? (Y/N)");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            Event findMurderWeapon = new Event("Find dagger", "You found a dagger in the Caroline's purse.");
            history.add(findMurderWeapon);
            System.out.println(findMurderWeapon.getDescription());
        }
    }
}