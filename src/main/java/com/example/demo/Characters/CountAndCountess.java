package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class CountAndCountess extends Character {

    public CountAndCountess() {
        super("Count and Countess Andrenyi", "Andrenyi description)");
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Andrenyis about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

        Event findCountessPassport = new Event("Find countess' passport", "You found a passport that uncovers more of countess' past.");
        characterEvents.add(findCountessPassport);

        Event talkAboutPassport = new Event("Talk about passport", "You talked to Andrenyis about passport you found.");
        characterEvents.add(talkAboutPassport);

        Event talkAboutBrush = new Event("Talk about smoking pipe brush", "You talked to Andrenyis about brush you found.");
        characterEvents.add(talkAboutBrush);
    }    
}