package com.example.TextGame.service;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.QuestionRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Character;
import com.example.TextGame.domain.Question;
import com.example.TextGame.viewmodel.QuestionVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class DialogService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;

    public Character getCharacter(int characterNumber) throws IOException {
        Character character = characterRepository.getCharacterFromFile(characterNumber);
        return character;
    }

    public ArrayList<QuestionVM> getVMQuestions(int characterNumber, String username) throws IOException {
        ArrayList<QuestionVM> vmquestions = new ArrayList<>();

        ArrayList<Question> questions = getPossibleQuestions(characterNumber, username);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);

        for(Question question: questions){
            boolean ifAsked = false;
            for(int a: asked){
                if(a == question.getNumber()){
                    ifAsked = true;
                }
            }
            QuestionVM vmquestion = new QuestionVM(question, ifAsked);
            vmquestions.add(vmquestion);
        }
        return vmquestions;
    }

    public ArrayList<String> answeredQuestions(int characterNumber, String username) throws IOException {
        ArrayList<String> askedQuestions = new ArrayList<>();
        ArrayList<Question> possibleQuestions = getPossibleQuestions(characterNumber, username);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);
        for(int i=0; i<possibleQuestions.size(); i++) {
            if (asked.contains(characterNumber)) {
                askedQuestions.add(String.valueOf('T'));
            }
            else{ askedQuestions.add(String.valueOf('F'));}
        }
        return askedQuestions;
    }

    public ArrayList<Question> getPossibleQuestions(int characterNumber, String username) throws IOException {
        ArrayList<Question> allCharacterQuestions = getCharacterQuestions(characterNumber);
        ArrayList<Question> possibleQuestions = new ArrayList<Question>();
        ArrayList<Integer> foundEvidence = userRepository.getFoundEvidence(username);
        for(int i=0; i<allCharacterQuestions.size(); i++){
            int evidenceNeeded = allCharacterQuestions.get(i).getEvidenceNeeded();
            int questionNumber = allCharacterQuestions.get(i).getNumber();

            if(characterNumber == allCharacterQuestions.get(i).getCharacter()) {
                if (evidenceNeeded == 0 || foundEvidence.contains(evidenceNeeded)) {
                    possibleQuestions.add(allCharacterQuestions.get(i));
                }
            }
        }
        return possibleQuestions;
    }

    public ArrayList<Question> getCharacterQuestions(int characterNumber) throws IOException {
        ArrayList<Question> allQuestions = questionRepository.getAllQuestions();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0; i<allQuestions.size(); i++){
            if (characterNumber == allQuestions.get(i).getCharacter()) {
                questions.add(allQuestions.get(i));
            }
        }
        return questions;
    }

    public void addQuestionToAsked(String username, int questionNumber) throws IOException {
        userRepository.addQuestionToAsked(username, questionNumber);
    }

    public QuestionVM getCurrentQuestion(int questionNumber) throws IOException {
        String username = CurrentSessionService.username();
        Question currentQuestion = questionRepository.getQuestionFromFile(questionNumber);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);
        boolean ifAsked = false;
        for(int a: asked){
            if(a == currentQuestion.getNumber()){
                ifAsked = true;
            }
        }
        return new QuestionVM(currentQuestion, ifAsked);
    }

    public void addEvidenceToFound(int evidence) throws IOException {
        String username = CurrentSessionService.username();
        if(Integer.valueOf(evidence) != 0){
            userRepository.addEvidenceToFound(username, Integer.valueOf(evidence));
        }
    }

    public ArrayList<QuestionVM> getConnectedQuestionsVM(int characterNumber, int questionNumber, String username) throws IOException {
        ArrayList<QuestionVM> availableQuestions = getVMQuestions(characterNumber, username);
        ArrayList<QuestionVM> questions = new ArrayList<>();
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);

        for (int i=0; i<availableQuestions.size(); i++) {
            if (availableQuestions.get(i).getPrevious() == questionNumber) {
                questions.add(availableQuestions.get(i));
            }
        }
        return questions;
    }

}
