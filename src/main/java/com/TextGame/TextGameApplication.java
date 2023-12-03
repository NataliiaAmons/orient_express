package com.TextGame;

import com.TextGame.domain.Question;
import com.TextGame.dao.CharacterRepository;
import com.TextGame.dao.QuestionRepository;
import com.TextGame.dao.UserRepository;
import com.TextGame.domain.Character;
import com.TextGame.service.CurrentSessionService;
import com.TextGame.service.DialogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
@Controller
public class TextGameApplication {



	public static void main(String[] args) {
		SpringApplication.run(TextGameApplication.class, args);
	}

	@Autowired
	private CharacterRepository characterRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	public DialogService dialogService;

	@Autowired
	public UserRepository userRepository;
	 /*
	@GetMapping("/")
	public String helloWorld(Model model) throws IOException {
		Character[] characters = new Character().getCharactersFromFile();
		Character character3 = characters[2];

		model.addAttribute("character", character3);

		String letter = "not found";
		model.addAttribute("letter", letter);


		return "character3";
	}
*/
	/*
	@GetMapping("/")
	// function to check if getting characters and questions from file works correctly
	public String getCharacters() throws IOException {
		Character character3 = characterRepository.getCharacterFromFile(2);

	 //for (int i = 0; i< character3.length; i++) {
		 System.out.printf("Character%d:\n%s\n%s\n%s\n%s\n\n", 2, String.valueOf(character3.getNumber()), character3.getName(), character3.getPhoto(), character3.getInfo());//System.out.printf("Qestions:\n");
	//	 ArrayList<Question> questions = characters[i].getQuestions();
	//	 for(Question index: questions){
		//	 System.out.printf("question%s\n%s\n%s\n%s\n%s\n\n\n", String.valueOf(index.getNumber()), index.getEvidenceNeeded(), index.getQuestionText(), index.getAnswer(), index.getPrevious());
		 //}
	// }

		return "character3";
	}
*/


	//@GetMapping("/")
	public String character1(Model model) {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String username = CurrentSessionService.getUsername(request);

			Character character3 = characterRepository.getCharacterFromFile(3);
			ArrayList<Character> allCharacters = characterRepository.getAllCharacters();
			ArrayList<Question> possibleQuestions = dialogService.getPossibleQuestions(3, username);
			model.addAttribute("character", character3);
			model.addAttribute("questions", possibleQuestions);

		}
		catch(IOException E){}

		String letter = "not found";
		model.addAttribute("letter", letter);
		return "character";
	}


}
