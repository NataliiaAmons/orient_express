package com.TextGame.service;

import com.TextGame.dao.CharacterRepository;
import com.TextGame.domain.Question;
import com.TextGame.dao.QuestionRepository;
import com.TextGame.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class DialogService {

    public DialogService(DialogService dialogService) throws IOException {
    }

    //findQuestions(Character questions
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;


    public DialogService()  {
    }

    public ArrayList<Question> getPossibleQuestions(int characterNumber, String username) throws IOException {
        ArrayList<Question> allCharacterQuestions = setQuestions(characterNumber);
        ArrayList<Question> possibleQuestions = new ArrayList<Question>();
        ArrayList<Integer> askedQuestions = userRepository.getAskedQuestions(username);
        ArrayList<Integer> foundEvidence = userRepository.getFoundEvidence(username);
        for(int i=0; i<allCharacterQuestions.size(); i++){
            int evidenceNeeded = allCharacterQuestions.get(i).getEvidenceNeeded();
            int questionNumber = allCharacterQuestions.get(i).getNumber();

            if(characterNumber == allCharacterQuestions.get(i).getCharacter()) {
                if (!askedQuestions.contains(questionNumber)) {
                    if (evidenceNeeded == 0 || foundEvidence.contains(evidenceNeeded)) {
                        possibleQuestions.add(allCharacterQuestions.get(i));
                    }
                }
            }
        }
        return possibleQuestions;
    }

    public ArrayList<Question> setQuestions(int characterNumber) throws IOException {
        ArrayList<Question> allQuestions = questionRepository.getAllQuestions();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0; i<allQuestions.size(); i++){
            if (characterNumber == allQuestions.get(i).getCharacter()) {
                questions.add(allQuestions.get(i));
            }
        }
        return questions;
    }

    public ArrayList<Question> getConnectedQuestions(int questionNumber) throws IOException {
        ArrayList<Question> allQuestions = questionRepository.getAllQuestions();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0; i<allQuestions.size(); i++){
            if (questionNumber == allQuestions.get(i).getPrevious()) {
                questions.add(allQuestions.get(i));
            }
        }
        return questions;
    }

}
