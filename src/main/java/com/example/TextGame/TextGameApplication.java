package com.example.TextGame;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.QuestionRepository;
import com.example.TextGame.domain.Character;
import com.example.TextGame.domain.Question;
import com.example.TextGame.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


	@GetMapping("/")
	public String character1(Model model) {
		try {
			Character character3 = characterRepository.getCharacterFromFile(3);
			ArrayList<Question> allCharacterQuestions = dialogService.setQuestions(3);
			model.addAttribute("character", character3);
			model.addAttribute("questions", allCharacterQuestions);

		}
		catch(IOException E){}

		String letter = "not found";
		model.addAttribute("letter", letter);
		return "character3";
	}

	//@GetMapping("killer.html")
	//public String killer(){
		//return "killer";
	//}
}
