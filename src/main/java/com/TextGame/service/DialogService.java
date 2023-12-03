package com.TextGame.service;

import com.TextGame.dao.CharacterRepository;
import com.TextGame.dao.EvidenceRepository;
import com.TextGame.dao.QuestionRepository;
import com.TextGame.dao.UserRepository;
import com.TextGame.domain.Character;
import com.TextGame.domain.Evidence;
import com.TextGame.domain.Question;
import com.TextGame.viewmodel.QuestionVM;
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
    private EvidenceRepository evidenceRepository;
    @Autowired
    private UserRepository userRepository;

    // tested
    public Character getCharacter(int characterNumber) throws IOException {
        Character character = characterRepository.getCharacterFromFile(characterNumber);
        return character;
    }
    // tested
    public ArrayList<QuestionVM> getFirstVMQuestions(int characterNumber, String username) throws IOException {
        ArrayList<QuestionVM> vmquestions = new ArrayList<>();

        ArrayList<Question> questions = getPossibleQuestions(characterNumber, username);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);

        for(Question question: questions){
            if(question.getPrevious()==0) {
                boolean ifAsked = false;
                for (int a : asked) {
                    if (a == question.getNumber()) {
                        ifAsked = true;
                    }
                }
                QuestionVM vmquestion = new QuestionVM(question, ifAsked);
                vmquestions.add(vmquestion);
            }
        }
        return vmquestions;
    }
    // tested
    public ArrayList<QuestionVM> getNextVMQuestions(int previousQuestion, int characterNumber, String username) throws IOException {
        ArrayList<QuestionVM> vmquestions = new ArrayList<>();

        ArrayList<Question> questions = getPossibleQuestions(characterNumber, username);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);

        for(Question question: questions){
            if(question.getPrevious()==previousQuestion) {
                boolean ifAsked = false;
                for (int a : asked) {
                    if (a == question.getNumber()) {
                        ifAsked = true;
                    }
                }
                QuestionVM vmquestion = new QuestionVM(question, ifAsked);
                vmquestions.add(vmquestion);
            }
        }
        return vmquestions;
    }
    // tested
    public ArrayList<String> answeredQuestions(int characterNumber, String username) throws IOException {
        ArrayList<String> askedQuestions = new ArrayList<>();
        ArrayList<Question> possibleQuestions = getPossibleQuestions(characterNumber, username);
        ArrayList<Integer> asked = userRepository.getAskedQuestions(username);
        for(int i=0; i<possibleQuestions.size(); i++) {
            if (asked.contains(possibleQuestions.get(i).getNumber())) {
                askedQuestions.add(String.valueOf('T'));
            }
            else{ askedQuestions.add(String.valueOf('F'));}
        }
        return askedQuestions;
    }
    // tested
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
    // tested
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
    // tested
    public void addQuestionToAsked(String username, int questionNumber) throws IOException {
        userRepository.addQuestionToAsked(username, questionNumber);
    }
    // tested
    public void addEvidenceToFound(int evidence) throws IOException {
        String username = CurrentSessionService.username();
        if(Integer.valueOf(evidence) != 0){
            userRepository.addEvidenceToFound(username, Integer.valueOf(evidence));
        }
    }

    public String getEvidencePhoto(int evidenceNumber) throws IOException {
        String photo = " ";
        if(evidenceNumber!=0){
            Evidence evidence = evidenceRepository.getItemFromFile(evidenceNumber, "evidence.csv");
            photo = evidence.getPhoto();
        }
        return photo;
    }

}
