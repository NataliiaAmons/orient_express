package com.example.TextGame.dao;

import com.example.TextGame.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class QuesionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void QuestionRepository_getQusertionFromFile() throws IOException {
        Question question = questionRepository.getQuestionFromFile(5);
        assertThat(question.getAnswer(), is("Ні, сер, не курю."));
        assertThat(question.getQuestionText(), is("Ви курите трубку?"));
        assertThat(question.getNumber(), is(5));
        assertThat(question.getCharacter(), is(1));
        assertThat(question.getEvidenceNeeded(), is(1));
        assertThat(question.getEvidenceGiven(), is(0));
        assertThat(question.getPrevious(), is(0));

    }

    @Test
    public void QuestionRepository_getAllQusertions() throws IOException {
        ArrayList<Question> questions = questionRepository.getAllQuestions();
        Question question5 = questions.get(4);
        assertThat(question5.getAnswer(), is("Ні, сер, не курю."));
        assertThat(question5.getQuestionText(), is("Ви курите трубку?"));
        assertThat(question5.getNumber(), is(5));
        assertThat(question5.getCharacter(), is(1));
        assertThat(question5.getEvidenceNeeded(), is(1));
        assertThat(question5.getEvidenceGiven(), is(0));
        assertThat(question5.getPrevious(), is(0));

    }
}
