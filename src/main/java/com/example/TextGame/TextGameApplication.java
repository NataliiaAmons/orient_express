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

	@GetMapping("/")
	public String dialog(){
		return "character3";
	}

	@GetMapping("Character1.html")
	public String character1(){
		return "character1";
	}

	@GetMapping("killer.html")
	public String killer(){
		return "killer";
	}
}
