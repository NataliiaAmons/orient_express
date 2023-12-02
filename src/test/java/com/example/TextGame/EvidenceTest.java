package com.example.TextGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TextGame.dao.EvidenceRepository;
import com.example.TextGame.domain.Evidence;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EvidenceTest {

    private EvidenceRepository evidenceRepository;

    @BeforeEach
    public void setUp() {
        evidenceRepository = new EvidenceRepository();
    }

    @Test
    public void testGetEvidenceFromFile() throws IOException {
        int number = 4;
        Evidence evidence = evidenceRepository.getItemFromFile(number, "evidence.csv");
        assertNotNull(evidence);

        assertEquals(number, evidence.getNumber());
        assertEquals("Носовичок", evidence.getName());
        assertEquals("handkerchief.png", evidence.getPhoto());
        assertEquals("Вишуканий батистовий носовичок. У кутку вишита велика літера 'Н' (може бути як англійська 'h', так і українська 'н').", evidence.getDescription());
        assertEquals("CrimeScene", evidence.getLocation());
    }

    @Test
    public void testGetAllEvidences() throws IOException {
        ArrayList<Evidence> allEvidences = evidenceRepository.getAllItems("evidence.csv");
        assertNotNull(allEvidences);

        // Checking if size of a list equals the amount
        assertEquals(7, allEvidences.size()); 

        // Testing for specific elements of list
        assertEquals(6, allEvidences.get(5).getNumber());
        assertEquals("Кинжал", allEvidences.get(5).getName());
        assertEquals("Прямий кинджал – дешева річ, обрамлений у східному стилі, з рельєфною рукояткою та конусоподібним лезом. Лезо було вкрите плямами та виглядало доволі брудним. На ньому немає жодних відбитків пальців, окрім місіс Хаббард.", allEvidences.get(5).getDescription());
        assertEquals("knife.png", allEvidences.get(5).getPhoto());
        assertEquals("InterrogationArea", allEvidences.get(5).getLocation());
    }
}