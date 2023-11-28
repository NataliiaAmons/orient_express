package com.example.TextGame.service;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.QuestionRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Character;
import com.example.TextGame.domain.Question;
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

    public ArrayList<Question> getQuestion(int characterNumber, int questionNumber) throws IOException {
        Character character = characterRepository.getCharacterFromFile(characterNumber);
        ArrayList<Question> allCharacterQuestions = setQuestions(characterNumber);
        ArrayList<Question> possibleQuestions = new ArrayList<Question>();
        for(int i=0; i<allCharacterQuestions.size(); i++){
            String evidenceNeeded = allCharacterQuestions.get(i).getEvidenceNeeded();
            if(userRepository.getQuetionStatus(allCharacterQuestions.get(i).getNumber()) == "" & userRepository.getEvidenceStatus(evidenceNeeded) == "found"){
                possibleQuestions.add(allCharacterQuestions.get(i));
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

}
