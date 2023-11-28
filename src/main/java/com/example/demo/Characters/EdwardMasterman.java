package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class EdwardMasterman extends Character {

    public EdwardMasterman() {
        super("Edward Masterman", "(Edward description)");
    
        Event talkAboutSleep = new Event("Talk about sleep aid", "You talked to Edward about sleeping issues that the victim had.");
        characterEvents.add(talkAboutSleep);

        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Edward about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

        Event talkAboutBrush = new Event("Talk about smoking pipe brush", "You talked to Edward about brush you found.");
        characterEvents.add(talkAboutBrush);
    }

}