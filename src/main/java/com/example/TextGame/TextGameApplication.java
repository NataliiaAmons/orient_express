package com.example.TextGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class TextGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextGameApplication.class, args);
	}
	//@GetMapping
	public String hello(){
		return "Hello World!";
	}

	@GetMapping
	public String welcome(){
		return "character8";
	}
}
