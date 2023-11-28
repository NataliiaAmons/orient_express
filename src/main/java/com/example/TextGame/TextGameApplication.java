package com.example.TextGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class TextGameApplication {



	public static void main(String[] args) {
		SpringApplication.run(TextGameApplication.class, args);
	}



/*
	@GetMapping("/")
	public String helloWorld(Model model) throws IOException {
		Character[] characters = characterRepository.getCharactersFromFile();
		Character character3 = characters[2];

		model.addAttribute("character", character3);

		String letter = "not found";
		model.addAttribute("letter", letter);


		return "character3";
	}

	//@GetMapping("/")
	// function to check if getting characters and questions from file works correctly
	public String getCharacters() throws IOException {
	 Character[] characters = new Character().getCharactersFromFile();

	 for (int i = 0; i< characters.length; i++) {
		 System.out.printf("Character%d:\n%s\n%s\n%s\n%s\n\n", i+1, String.valueOf(characters[i].getNumber()), characters[i].getName(), characters[i].getPhoto(), characters[i].getInfo());
		 System.out.printf("Qestions:\n");
		 ArrayList<Question> questions = characters[i].getQuestions();
		 for(Question index: questions){
			 System.out.printf("question%s\n%s\n%s\n%s\n%s\n\n\n", String.valueOf(index.getNumber()), index.getEvidenceNeeded(), index.getQuestionText(), index.getAnswer(), index.getPrevious());
		 }
	 }

		return "TEST";
	}

*/

	@GetMapping("/")
	public String character1(){
		return "killer";
	}

	@GetMapping("killer.html")
	public String killer(){
		return "killer";
	}
}
