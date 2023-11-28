package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Characters.CarolineHubbard;
import com.example.demo.Characters.CountAndCountess;
import com.example.demo.Characters.EdwardMasterman;
import com.example.demo.Characters.HectorMacQueen;
import com.example.demo.Characters.HildegardeSchmidt;
import com.example.demo.Characters.MaryDebenham;
import com.example.demo.Characters.NataliaDragomiroff;
import com.example.demo.Characters.PierreMichel;
import com.example.demo.Locations.CrimeScene;
import com.example.demo.Locations.InvestigationArea;
import com.example.demo.Objects.Brush;
import com.example.demo.Objects.BurnedLetter;
import com.example.demo.Objects.EmptyGlass;
import com.example.demo.Objects.Handkerchief;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		List<Event> history = new ArrayList<>();

        try {
            CharactersInfo[] characters = new CharactersInfo().getCharactersFromFile();
    
            // Assume HectorMacQueen is character1
            HectorMacQueen hectorMacQueen = new HectorMacQueen(characters[0]);
    
            // Now you can access information and interact with HectorMacQueen
            hectorMacQueen.interact(history);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start

        // Location "Crime Scene"
    
        CrimeScene CrimeScene = new CrimeScene();
        EmptyGlass EmptyGlass = new EmptyGlass(); Brush Brush = new Brush(); BurnedLetter Letter = new BurnedLetter(); Handkerchief Handkerchief = new Handkerchief();
    
        CrimeScene.addObject(EmptyGlass); CrimeScene.addObject(Brush); CrimeScene.addObject(Letter); CrimeScene.addObject(Handkerchief);
    
        CrimeScene.pointOfInterest(history);
    
        // Location "Train Cart"
    
        InvestigationArea InvestigationArea = new InvestigationArea();
        CarolineHubbard Caroline = new CarolineHubbard(); CountAndCountess CountAndCountess = new CountAndCountess(); EdwardMasterman Edward = new EdwardMasterman();
       // HectorMacQueen Hector = new HectorMacQueen();
        HildegardeSchmidt Hildegarde = new HildegardeSchmidt(); MaryDebenham Mary = new MaryDebenham();
        NataliaDragomiroff Natalia = new NataliaDragomiroff(); PierreMichel Pierre = new PierreMichel();
    
        InvestigationArea.addCharacter(Caroline); InvestigationArea.addCharacter(CountAndCountess); InvestigationArea.addCharacter(Edward);
    //  InvestigationArea.addCharacter(Hector); InvestigationArea.addCharacter(Hildegarde); InvestigationArea.addCharacter(Mary);
        InvestigationArea.addCharacter(Natalia); InvestigationArea.addCharacter(Pierre);

        InvestigationArea.pointOfInterest(history);
        
        // Caroline possible events
        Caroline.historyConnection(history, "Examining burned paper", null, Caroline.getEvent("Talk about burned paper pieces"));
        Caroline.historyConnection(history, "Examining handkerchief", null, Caroline.getEvent("Talk about fine handkerchief"));
        // murder weapon WIP
        
        // Andrenyis possible events
        CountAndCountess.historyConnection(history, "Examining burned paper", null, CountAndCountess.getEvent("Talk about burned paper pieces"));
        CountAndCountess.historyConnection(history, "Examining cleaning brush", null, CountAndCountess.getEvent("Talk about smoking pipe brush"));
        // passport WIP

        // Edward possible events
        Edward.historyConnection(history, "Examining burned paper", null, Edward.getEvent("Talk about burned paper pieces"));
        Edward.historyConnection(history, "Examining cleaning brush", null, Edward.getEvent("Talk about smoking pipe brush"));
        Edward.historyConnection(history, "Examining glass", null, Edward.getEvent("Talk about sleep aid"));

        // Hector possible events
   //   Hector.historyConnection(history, "Examining burned paper", null, Hector.getEvent("Talk about burned paper pieces"));
   //   Hector.historyConnection(history, "Examining cleaning brush", null, Hector.getEvent("Talk about smoking pipe brush"));

        // Hildegarde possible events
        Hildegarde.historyConnection(history, "Examining burned paper", null, Hildegarde.getEvent("Talk about burned paper pieces"));
        Hildegarde.historyConnection(history, "Examining handkerchief", null, Hildegarde.getEvent("Talk about fine handkerchief"));
        Hildegarde.historyConnection(history, "Ask princess about her evening", null, Hildegarde.getEvent("Talk about Princess' time last evening"));

        // Mary possible events
        Mary.historyConnection(history, "Examining burned paper", null, Mary.getEvent("Talk about burned paper pieces"));

        // Natalia possible events
        Natalia.historyConnection(history, "Examining burned paper", null, Natalia.getEvent("Talk about burned paper pieces"));
        Natalia.historyConnection(history, "Examining handkerchief", null, Natalia.getEvent("Talk about fine handkerchief"));

        // Pierre possible events
        Pierre.historyConnection(history, "Examining cleaning brush", null, Pierre.getEvent("Talk about smoking pipe brush"));
        Pierre.historyConnection(history, "Get button", null, Pierre.getEvent("Talk about the button"));

        // Final
    }
}