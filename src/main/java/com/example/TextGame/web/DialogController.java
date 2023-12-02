package com.example.TextGame.web;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.QuestionRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.Character;
import com.example.TextGame.domain.Question;
import com.example.TextGame.service.CurrentSessionService;
import com.example.TextGame.service.DialogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.ArrayList;

@Controller
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


    @PostMapping("/dialog")
    public String getCharacter(@ModelAttribute("characterNumber") String characterNumber, Model model) throws IOException {
        System.out.println("character:" + characterNumber);
        Character character = characterRepository.getCharacterFromFile(Integer.parseInt(characterNumber));
        model.addAttribute("character", character);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);

        ArrayList<Question> questions = dialogService.getPossibleQuestions(Integer.parseInt(characterNumber), username);
        model.addAttribute("questions", questions);
        //redirectAttributes.addFlashAttribute( "character", currentCharacter);
//
        //return new ModelAndView("redirect:/character", (Map<String, ?>) model);
        return "character";
    }

    @GetMapping("/character")
    public String getCharacter(@ModelAttribute("character") Character character, Model model) throws IOException {
        System.out.println("some=" + character.getName());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);

        ArrayList<Question> allQuestions = questionRepository.getAllQuestions();
        ArrayList<Question> availableQuestions = dialogService.getPossibleQuestions(character.getNumber(), username);
        model.addAttribute("availableQuestions", availableQuestions);
        int Previous = 0;
        model.addAttribute("Previous", Previous);
        //redirectAttributes.addFlashAttribute( "character", currentCharacter);
//
        //return new ModelAndView("redirect:/character", (Map<String, ?>) model);
        return "character";
    }

    @PostMapping("/character")
    public String getCharacter(@ModelAttribute("characterNumber") String characterNumber, @ModelAttribute("questionNumber") String questionNumber, @ModelAttribute("answer") String answer, @ModelAttribute("evidenceGiven") String evidenceGiven, Model model) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);
        userRepository.addQuestionToAsked(username, Integer.valueOf(questionNumber));
        if(Integer.valueOf(evidenceGiven) != 0){
            userRepository.addEvidenceToFound(username, Integer.valueOf(evidenceGiven));
        }
        ArrayList<Question> availableQuestions = dialogService.getPossibleQuestions(Integer.valueOf(characterNumber), username);
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0; i<availableQuestions.size(); i++) {
            if (availableQuestions.get(i).getPrevious() == Integer.valueOf(questionNumber)) {
                questions.add(availableQuestions.get(i));
            }
        }
        Character character = characterRepository.getCharacterFromFile(Integer.valueOf(characterNumber));
        model.addAttribute("character", character);
        model.addAttribute("Previous", character);

        int Previous = Integer.valueOf(questionNumber);
        model.addAttribute("questions", questions);
        model.addAttribute("Previous", Previous);
        model.addAttribute("answer", answer);
        model.addAttribute("evidenceGiven", evidenceGiven);

        return "character";
    }


    //@PostMapping("/dialog")
    public String getQuestion(@PathVariable("questionNumber") String questionNumber, Model model) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);

        com.example.TextGame.domain.Question currentQuestion = questionRepository.getQuestionFromFile(Integer.valueOf(questionNumber));
        userRepository.addQuestionToAsked(username, Integer.valueOf(questionNumber));
        model.addAttribute("currentQuestion", questionNumber);
        return "character";
    }

}
