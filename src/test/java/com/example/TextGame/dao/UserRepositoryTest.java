package com.example.TextGame.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    public void UserRepository_getAskedQuestions() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;sdf\n2;sdf\n3;sdf\n4;dfgdf\n5;dfgd\n6;dfg");
        try {
            writer.close();
        } catch (IOException e) {
        }

        ArrayList<Integer> questions = userRepository.getAskedQuestions("test");

        ArrayList<Integer> expected = new ArrayList<>();
        int[] e = {1, 2, 3, 4, 5, 6};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected ,questions);
    }

    @Test
    public void UserRepository_getAskedQuestionsAndDate() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2023-11-30T20:17:13.839904700\n2;2023-11-30T20:12:59.121384100\n3;2023-11-30T20:19:12.974531600\n4;2023-11-30T20:19:49.847965500\n5;2023-11-30T20:20:04.919562200\n6;2023-11-30T20:20:04.924463300");
        try {
            writer.close();
        } catch (IOException e) {
        }

        ArrayList<String[]> questions = userRepository.getAskedQuestionsWithData("test");

        ArrayList<String[]> expected = new ArrayList<>();
        String[][] e = new String[][]{{"1", "2023-11-30T20:17:13.839904700"}, {"2","2023-11-30T20:12:59.121384100"}, {"3", "2023-11-30T20:19:12.974531600"}, {"4", "2023-11-30T20:19:49.847965500"}, {"5", "2023-11-30T20:20:04.919562200"}, {"6", "2023-11-30T20:20:04.924463300"}};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected.get(0)[0] ,questions.get(0)[0]);
        assertEquals(expected.get(0)[1] ,questions.get(0)[1]);
        assertEquals(expected.get(1)[0] ,questions.get(1)[0]);
        assertEquals(expected.get(1)[1] ,questions.get(1)[1]);
        assertEquals(expected.get(2)[0] ,questions.get(2)[0]);
        assertEquals(expected.get(2)[1] ,questions.get(2)[1]);
        assertEquals(expected.get(3)[0] ,questions.get(3)[0]);
        assertEquals(expected.get(3)[1] ,questions.get(3)[1]);
        assertEquals(expected.get(4)[0] ,questions.get(4)[0]);
        assertEquals(expected.get(4)[1] ,questions.get(4)[1]);
        assertEquals(expected.get(5)[0] ,questions.get(5)[0]);
        assertEquals(expected.get(5)[1] ,questions.get(5)[1]);
    }

    @Test
    public void UserRepository_addQuestionToAsked() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2023-11-30T20:17:13.839904700\n2;2023-11-30T20:12:59.121384100\n3;2023-11-30T20:19:12.974531600\n4;2023-11-30T20:19:49.847965500\n5;2023-11-30T20:20:04.919562200\n6;2023-11-30T20:20:04.924463300");
        try {
            writer.close();
        } catch (IOException e) {
        }

        userRepository.addQuestionToAsked("test", 7);
        ArrayList<String[]> questions = userRepository.getAskedQuestionsWithData("test");
        LocalDateTime expectedData = LocalDateTime.now();
        LocalDateTime resultData = LocalDateTime.parse(questions.get(6)[1]);

        ArrayList<String[]> expected = new ArrayList<>();
        String[][] e = new String[][]{{"1", "2023-11-30T20:17:13.839904700"}, {"2","2023-11-30T20:12:59.121384100"}, {"3", "2023-11-30T20:19:12.974531600"}, {"4", "2023-11-30T20:19:49.847965500"}, {"5", "2023-11-30T20:20:04.919562200"}, {"6", "2023-11-30T20:20:04.924463300"}};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }
        String[] add = new String[]{String.valueOf(7), String.valueOf(expectedData)};
        expected.add(add);

        assertEquals(expected.get(0)[0] ,questions.get(0)[0]);
        assertEquals(expected.get(0)[1] ,questions.get(0)[1]);
        assertEquals(expected.get(1)[0] ,questions.get(1)[0]);
        assertEquals(expected.get(1)[1] ,questions.get(1)[1]);
        assertEquals(expected.get(2)[0] ,questions.get(2)[0]);
        assertEquals(expected.get(2)[1] ,questions.get(2)[1]);
        assertEquals(expected.get(3)[0] ,questions.get(3)[0]);
        assertEquals(expected.get(3)[1] ,questions.get(3)[1]);
        assertEquals(expected.get(4)[0] ,questions.get(4)[0]);
        assertEquals(expected.get(4)[1] ,questions.get(4)[1]);
        assertEquals(expected.get(5)[0] ,questions.get(5)[0]);
        assertEquals(expected.get(5)[1] ,questions.get(5)[1]);
        assertEquals(expected.get(6)[0] ,questions.get(6)[0]);
        assertTrue(120>resultData.until(expectedData, ChronoUnit.SECONDS));
    }

    @Test
    public void UserRepository_addQuestionToAsked_alreadyAsked() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2023-11-30T20:17:13.839904700\n2;2023-11-30T20:12:59.121384100\n3;2023-11-30T20:19:12.974531600\n4;2023-11-30T20:19:49.847965500\n5;2023-11-30T20:20:04.919562200\n6;2023-11-30T20:20:04.924463300");
        try {
            writer.close();
        } catch (IOException e) {
        }

        userRepository.addQuestionToAsked("test", 3);
        ArrayList<String[]> questions = userRepository.getAskedQuestionsWithData("test");
        LocalDateTime expectedData = LocalDateTime.now();
        LocalDateTime resultData = LocalDateTime.parse(questions.get(5)[1]);

        ArrayList<String[]> expected = new ArrayList<>();
        String[][] e = new String[][]{{"1", "2023-11-30T20:17:13.839904700"}, {"2","2023-11-30T20:12:59.121384100"}, {"3", "2023-11-30T20:19:12.974531600"}, {"4", "2023-11-30T20:19:49.847965500"}, {"5", "2023-11-30T20:20:04.919562200"}, {"6", "2023-11-30T20:20:04.924463300"}};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected.get(0)[0] ,questions.get(0)[0]);
        assertEquals(expected.get(0)[1] ,questions.get(0)[1]);
        assertEquals(expected.get(1)[0] ,questions.get(1)[0]);
        assertEquals(expected.get(1)[1] ,questions.get(1)[1]);
        assertEquals(expected.get(3)[0] ,questions.get(2)[0]);
        assertEquals(expected.get(3)[1] ,questions.get(2)[1]);
        assertEquals(expected.get(4)[0] ,questions.get(3)[0]);
        assertEquals(expected.get(4)[1] ,questions.get(3)[1]);
        assertEquals(expected.get(5)[0] ,questions.get(4)[0]);
        assertEquals(expected.get(5)[1] ,questions.get(4)[1]);
        assertEquals(expected.get(2)[0] ,questions.get(5)[0]);
        assertTrue(120>resultData.until(expectedData, ChronoUnit.SECONDS));
    }
}
