package com.example.TextGame.web;

import com.example.TextGame.domain.Character;
import com.example.TextGame.service.CurrentSessionService;
import com.example.TextGame.service.DialogService;
import com.example.TextGame.viewmodel.QuestionVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class DialogController {
    public DialogController(DialogService dialogService) {
        this.dialogService = dialogService;
    }

    @Autowired
    private DialogService dialogService;

    @PostMapping("/dialog")
    public String getCharacter(@ModelAttribute("characterNumber") String characterNumber, Model model) throws IOException {
        String username = CurrentSessionService.username();
        System.out.println("dialog: username - " + username);
        Character character = dialogService.getCharacter(Integer.parseInt(characterNumber));
        ArrayList<QuestionVM> questions = dialogService.getFirstVMQuestions(Integer.parseInt(characterNumber), username);

        model.addAttribute("character", character);
        model.addAttribute("questions", questions);
        model.addAttribute("info", true);
        model.addAttribute("answerToPrevious", null);

        return "character";
    }

    @GetMapping("/character")
    public String getCharacter(@ModelAttribute("character") Character character, Model model) throws IOException {
        String username = CurrentSessionService.username();
        ArrayList<QuestionVM> availableQuestions = dialogService.getFirstVMQuestions(character.getNumber(), username);

        model.addAttribute("availableQuestions", availableQuestions);
        model.addAttribute("Previous", false);
        model.addAttribute("answerToPrevious", null);
        model.addAttribute("info", false);

        return "character";
    }

    @PostMapping("/character")
    public String getCharacter(@ModelAttribute("characterNumber") String characterNumber, @ModelAttribute("questionNumber") String questionNumber, @ModelAttribute("answer") String answer, @ModelAttribute("evidenceGiven") String evidenceGiven, Model model) throws IOException {
         String username = CurrentSessionService.username();
        dialogService.addQuestionToAsked(username, Integer.valueOf(questionNumber));

        dialogService.addEvidenceToFound(Integer.valueOf(evidenceGiven));

        ArrayList<QuestionVM> questions = dialogService.getNextVMQuestions(Integer.valueOf(questionNumber), Integer.valueOf(characterNumber), username);

        ArrayList<String> askedQuestions = dialogService.answeredQuestions(Integer.valueOf(characterNumber), username);
        model.addAttribute("askedQuestions", askedQuestions);
        Character character = dialogService.getCharacter(Integer.valueOf(characterNumber));
        model.addAttribute("character", character);

        model.addAttribute("questions", questions);
        model.addAttribute("Previous", true);
        model.addAttribute("PreviousNumber", Integer.valueOf(questionNumber));
        model.addAttribute("answerToPrevious", answer);
        model.addAttribute("isAnswer", true);
        model.addAttribute("evidenceGiven", evidenceGiven);
        boolean info = false;
        model.addAttribute("info", info);

        return "character1";
    }


    //@PostMapping("/dialog")
    public String getQuestion(@PathVariable("character") String character, @PathVariable("questionNumber") String questionNumber, Model model) throws IOException {

        String username = CurrentSessionService.username();
        dialogService.addQuestionToAsked(username, Integer.valueOf(questionNumber));

        ArrayList<QuestionVM> availableQuestions = dialogService.getVMQuestions(Integer.valueOf(character), username);
        QuestionVM currentQuestion = dialogService.getCurrentQuestion(Integer.valueOf(questionNumber));

        model.addAttribute("availableQuestions", availableQuestions);
        model.addAttribute("currentQuestionNumber", questionNumber);

        return "character";
    }

}
