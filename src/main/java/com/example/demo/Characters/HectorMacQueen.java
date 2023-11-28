package com.example.demo.Characters;

import com.example.demo.Character;
import com.example.demo.CharactersInfo;
import com.example.demo.Event;

public class HectorMacQueen extends Character {

    public HectorMacQueen(CharactersInfo Hector) {
        super(Hector.getName(), Hector.getInfo());
    
        Event talkAboutLetter = new Event("Talk about burned paper pieces", "You talked to Hector about destroyed letter you found.");
        characterEvents.add(talkAboutLetter);

        Event talkAboutBrush = new Event("Talk about smoking pipe brush", "You talked to Hector about brush you found.");
        characterEvents.add(talkAboutBrush);
    }

 // @Override
 // public void interact(List<Event> history) {

 //      try {
 //     CharactersInfo[] characters = new CharactersInfo().getCharactersFromFile();

 //     // Assume HectorMacQueen is character1
 //     HectorMacQueen hectorMacQueen = new HectorMacQueen(characters[0]);

 //     // Now you can access information and interact with HectorMacQueen
 //     hectorMacQueen.interact(history);
 // } catch (IOException e) {
 //     e.printStackTrace();
 // }
 // 
 //     System.out.println(getDescription());
 //     System.out.println("Do you want to interact with " + getName() + "?");
 //     String option = scanner.next();
 //     if (option.equals("Y")) {
 //         Event event = new Event(name, description);
 //         history.add(event);
 //         System.out.println(getDescription());
 //     }
 // }
   
}