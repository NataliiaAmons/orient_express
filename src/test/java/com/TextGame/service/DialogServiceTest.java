package com.TextGame.service;

import com.TextGame.dao.UserRepository;
import com.TextGame.domain.Character;
import com.TextGame.domain.Question;
import com.TextGame.viewmodel.QuestionVM;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DialogServiceTest {

    @Autowired
    private DialogService dialogService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrentSessionService currentSessionService;

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

    @Test
    public void DialogService_getCharacter() throws IOException {
        Character character = dialogService.getCharacter(5);
        assertThat(character.getNumber(), is(5));
        assertThat(character.getName(), is("провідник П'єр Мішель"));
        assertThat(character.getInfo(), is("Провідник, який працює на Східному експресі."));
        assertThat(character.getPhoto(), is("character5.png"));
    }
    @Test
    public void DialogService_getPossibleQuestions() throws IOException {
        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer.write("1;2;3;");
        try {
            writer.close();
        } catch (IOException e) {
        }

        ArrayList<Question> possibleQuestions = dialogService.getPossibleQuestions(1, "test");
        int[] expected = {2, 3, 4, 5};

        assertEquals(4, possibleQuestions.size());
        assertEquals(expected[0], possibleQuestions.get(0).getNumber());
        assertEquals(expected[1], possibleQuestions.get(1).getNumber());
        assertEquals(expected[2], possibleQuestions.get(2).getNumber());
        assertEquals(expected[3], possibleQuestions.get(3).getNumber());
    }
    @Test
    public void DialogService_getFirstVMQuestions() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer1 = null;
        try {
            writer1 = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer1.write("1;sdf\n2;sdf\n5;dfgd");
        try {
            writer1.close();
        } catch (IOException e) {
        }

        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer2 = null;
        try {
            writer2 = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer2.write("1;2;3;4;5;6");
        try {
            writer2.close();
        } catch (IOException e) {
        }

        ArrayList<QuestionVM> questions = dialogService.getFirstVMQuestions(1, "test");

        assertEquals(4, questions.size());
        assertTrue(questions.get(1).isAsked());
        assertFalse(questions.get(2).isAsked());
        assertThat(questions.get(3).getAnswer(), is("Ні, сер, не курю."));
        assertThat(questions.get(3).getQuestionText(), is("Ви курите трубку?"));
        assertEquals(questions.get(3).getNumber(), 5);
        assertEquals(questions.get(3).getCharacter(), 1);
        assertEquals(questions.get(3).getEvidenceNeeded(), 1);
        assertEquals(questions.get(3).getPrevious(), 0);
        assertEquals(questions.get(3).getEvidenceGiven(), 0);
    }
    @Test
    public void DialogService_getCharacterQuestions() throws IOException {

        ArrayList<Question> characterQuestions = dialogService.getCharacterQuestions(7);

        int[] expected = {50, 51, 52, 53, 54};
        assertEquals(5, characterQuestions.size());
        assertEquals(expected[0], characterQuestions.get(0).getNumber());
        assertEquals(expected[1], characterQuestions.get(1).getNumber());
        assertEquals(expected[2], characterQuestions.get(2).getNumber());
        assertEquals(expected[3], characterQuestions.get(3).getNumber());
        assertEquals(expected[4], characterQuestions.get(4).getNumber());
    }
    @Test
    public void DialogService_getNextVMQuestions() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer1 = null;
        try {
            writer1 = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer1.write("1;sdf\n2;sdf\n5;dfgd");
        try {
            writer1.close();
        } catch (IOException e) {
        }

        Path evidence_path = this.workingDir.resolve("testevidence.csv");
        BufferedWriter writer2 = null;
        try {
            writer2 = Files.newBufferedWriter(evidence_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer2.write("1;2;3;4;5;6");
        try {
            writer2.close();
        } catch (IOException e) {
        }

        ArrayList<QuestionVM> questions = dialogService.getNextVMQuestions(2, 1,"test");

        assertEquals(1, questions.size());
        assertFalse(questions.get(0).isAsked());
        assertEquals(questions.get(0).getNumber(), 3);
        assertEquals(questions.get(0).getCharacter(), 1);
        assertEquals(questions.get(0).getEvidenceNeeded(), 0);
        assertEquals(questions.get(0).getPrevious(), 2);
        assertEquals(questions.get(0).getEvidenceGiven(), 0);
    }

    @Test
    public void DialogService_answeredQuestions() throws IOException {
        Path questions_path = this.workingDir.resolve("testquestions.csv");
        BufferedWriter writer1 = null;
        try {
            writer1 = Files.newBufferedWriter(questions_path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        writer1.write("1;sdf\n2;sdf\n5;dfgd");
        try {
            writer1.close();
        } catch (IOException e) {
        }

        ArrayList<String> answeredQuestions = dialogService.answeredQuestions(1, "test");

        assertEquals(5, answeredQuestions.size());
        assertEquals("T", answeredQuestions.get(0));
        assertEquals("T", answeredQuestions.get(1));
        assertEquals("F", answeredQuestions.get(2));
        assertEquals("F", answeredQuestions.get(3));
        assertEquals("T", answeredQuestions.get(4));
    }

    @Test
    public void DialogService_addQuestionToAsked() throws IOException {
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

        dialogService.addQuestionToAsked("test", 7);
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
    public void DialogService_addEvidenceToFound() throws IOException {
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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        currentSessionService.addUsernameToSession(request, "test");
        dialogService.addEvidenceToFound(7);

        ArrayList<Integer> evidence = userRepository.getFoundEvidence("test");
        ArrayList<Integer> expected = new ArrayList<>();
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        for(int i=0; i<e.length; i++){
            expected.add(e[i]);
        }

        assertEquals(expected ,evidence);
    }

    @Test
    public void DialogService_getEvidencePhoto() throws IOException {

        String photo = dialogService.getEvidencePhoto(3);
        assertEquals(photo, "gun-removebg-preview.png");
    }
}
