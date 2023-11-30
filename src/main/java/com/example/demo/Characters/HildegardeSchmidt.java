package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.Event;

public class HildegardeSchmidt extends Character {

    public HildegardeSchmidt() {
        super("Hildegarde Schmidt", "Hidegarde description)");
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Hildegarde about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

        Event talkAboutHandkerchief = new Event("Talk about fine handkerchief", "You talked to Hildegarde about handkerchief you found.");
        characterEvents.add(talkAboutHandkerchief);

        Event talkAboutPrincess = new Event("Talk about Princess' time last evening", "You talked to Hildegarde about handkerchief you found.");
        characterEvents.add(talkAboutPrincess);
    }    
}