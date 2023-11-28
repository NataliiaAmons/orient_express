package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    @PostMapping("/your-java-endpoint")
    public String handleButtonClicked(Model model) {
        // Process the chosen option and add the result to the model
        String result = "Option chosen successfully!";
        model.addAttribute("result", result);

        // Return the template name to be rendered
        return "index"; // Thymeleaf will look for a template named "index.html"
    }
}
