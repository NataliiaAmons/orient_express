package com.example.TextGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TextGame.dao.ConclusionRepository;
import com.example.TextGame.domain.Conclusion;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConclusionTest {

    private ConclusionRepository conclusionRepository;

    @BeforeEach
    public void setUp() {
        conclusionRepository = new ConclusionRepository();
    }

    @Test
    public void testGetConclusionFromFile() throws IOException {
        int number = 2;
        Conclusion conclusion = conclusionRepository.getItemFromFile(number, "conclusions.csv");
        assertNotNull(conclusion);

        assertEquals(number, conclusion.getNumber());
        assertEquals("SuspectConductorOfBrush", conclusion.getName());
        assertEquals("Провідник є можливим вбивцею, бо він курить трубку.", conclusion.getDescription());
    }

    @Test
    public void testGetAllConclusion() throws IOException {
        ArrayList<Conclusion> allConclusion = conclusionRepository.getAllItems("conclusions.csv");
        assertNotNull(allConclusion);

        // Checking if size of a list equals the amount
        assertEquals(4, allConclusion.size()); 

        // Testing for specific elements of list
        assertEquals(1, allConclusion.get(0).getNumber());
        assertEquals("SuspectConductorOfButton", allConclusion.get(2).getName());
        assertEquals("Провідник є можливим вбивцею, бо знайдений ґудзик належить комусь з персоналу.", allConclusion.get(2).getDescription());
    }
}