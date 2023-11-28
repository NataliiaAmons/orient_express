package com.example.TextGame.web;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.QuestionRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Character;
import com.example.TextGame.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DialogController {
    public DialogController(DialogService dialogService) {
        this.dialogService = dialogService;
    }

    @Autowired
    private DialogService dialogService;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;



    @GetMapping("dialogs/{characterNumber}")
    public String getCharacter(@PathVariable("characterNumber") int characterNumber, Model model) throws IOException {
        Character currentCharacter = characterRepository.getCharacterFromFile(characterNumber);
        model.addAttribute("character", currentCharacter);
        return "character";
    }

    @GetMapping("dialogs/{characterNumber}/{questionNumber}")
    public String getCharacter(@PathVariable("characterNumber") int characterNumber, @PathVariable("questionNumber") int questionNumber, Model model) throws IOException {
        com.example.TextGame.domain.Question currentQuestion = questionRepository.getQuestionFromFile(questionNumber);
        userRepository.setQuestionStatusToAnswered(questionNumber);
        model.addAttribute("currentQuestion", questionNumber);
        return "character";
    }

}
