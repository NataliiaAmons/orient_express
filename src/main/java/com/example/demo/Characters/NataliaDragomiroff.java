package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class NataliaDragomiroff extends Character {

    public NataliaDragomiroff() {
        super("Natalia Dragomiroff", "Natalia description)");
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Natalia about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

        Event talkAboutHandkerchief = new Event("Talk about fine handkerchief", "You talked to Natalia about handkerchief you found.");
        characterEvents.add(talkAboutHandkerchief);

    //   Event talkWithPrincess = new Event("Talk about burned paper pieces", "You talked to Natalia about destroyed letter you found.");
    //   characterEvents.add(talkWithPrincess);
    }    
}