package com.example.TextGame.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private final Path workingDir = Path.of("", "src/main/resources/users/");

    @Test
    public void UserRepository_createUserFiles() throws IOException {
        userRepository.createUserFiles("username");

        boolean isCreated = userRepository.isCreated("username");

        assertThat(isCreated ,is(true));
    }

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
        writer.write("1;2;3;4;5;6");
        try {
            writer.close();
        } catch (IOException e) {
        }

        ArrayList<Integer> evidence = userRepository.getFoundEvidence("test");

        ArrayList<Integer> expected = new ArrayList<>();
        int[] e = {1, 2, 3, 4, 5, 6};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected ,evidence);
    }

    @Test
    public void UserRepository_addEvidenceToFound() throws IOException {
        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2;3;4;5;6");
        try {
            writer.close();
        } catch (IOException e) {
        }

        userRepository.addEvidenceToFound("test",7);

        ArrayList<Integer> evidence = userRepository.getFoundEvidence("test");
        ArrayList<Integer> expected = new ArrayList<>();
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected ,evidence);
    }

    @Test
    public void UserRepository_addEvidenceToFound_alreadyInList() throws IOException {
        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2;3;4;5;6");
        try {
            writer.close();
        } catch (IOException e) {
        }

        userRepository.addEvidenceToFound("test",4);

        ArrayList<Integer> evidence = userRepository.getFoundEvidence("test");
        ArrayList<Integer> expected = new ArrayList<>();
        int[] e = {1, 2, 3, 4, 5, 6};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected ,evidence);
    }



}
