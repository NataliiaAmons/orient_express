package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class PierreMichel extends Character {

    public PierreMichel() {
        super("Pierre Michel", "Pierre description)");
    
        Event talkAboutBrush = new Event("Talk about smoking pipe brush", "You talked to Hector about brush you found.");
        characterEvents.add(talkAboutBrush);

        Event talkAboutButton = new Event("Talk about the button", "You talked to Pierre about button that Caroline found.");
        characterEvents.add(talkAboutButton);
    }    
}