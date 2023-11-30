package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class MaryDebenham extends Character {

    public MaryDebenham() {
        super("Mary Debenham", "Mary description)");
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Mary about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);
    }    
}