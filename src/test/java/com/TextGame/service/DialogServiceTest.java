package com.TextGame.service;

import com.TextGame.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DialogServiceTest {

    @Autowired
    private DialogService dialogService;

    private final Path workingDir = Path.of("", "src/main/resources/users/");

    @Test
    public void UserRepository_getFoundEvidence() throws IOException {
        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;6");
        try {
            writer.close();
        } catch (IOException e) {
        }

        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer2 = null;
        try {
            writer2 = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer2.write("2;2023-11-30T20:17:13.839904700");
        try {
            writer2.close();
        } catch (IOException e) {
        }

        ArrayList<Question> evidence = dialogService.getPossibleQuestions(1, "test");

        int[] expected = {2, 3, 4, 5};

        assertEquals(expected[0] ,evidence.get(0).getNumber());
        assertEquals(expected[1] ,evidence.get(1).getNumber());
        assertEquals(expected[2] ,evidence.get(2).getNumber());
        assertEquals(expected[3] ,evidence.get(3).getNumber());
    }

    @Test
    public void UserRepository_getFoundEvidence_7thcharacter() throws IOException {
        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;6");
        try {
            writer.close();
        } catch (IOException e) {
        }

        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer2 = null;
        try {
            writer2 = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer2.write("2;2023-11-30T20:17:13.839904700\n22;2023-11-30T20:17:13.839904700\n52;2023-11-30T20:17:13.839904700");
        try {
            writer2.close();
        } catch (IOException e) {
        }

        ArrayList<Question> evidence = dialogService.getPossibleQuestions(7, "test");

        //ArrayList<Integer> expected = new ArrayList<>();
        int[] expected = {50, 51, 53, 54};
        //for(int i=0; i<e.length; i++){
        //expected.add(e[i]);
        //}

        assertEquals(expected[0] ,evidence.get(0).getNumber());
        assertEquals(expected[1] ,evidence.get(1).getNumber());
        assertEquals(expected[2] ,evidence.get(2).getNumber());
        assertEquals(expected[3] ,evidence.get(3).getNumber());
    }
}
