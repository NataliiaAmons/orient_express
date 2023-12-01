package com.example.TextGame.web;

import com.example.TextGame.domain.Character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

public class MurderSceneController {
    @GetMapping("/SceneOfTheMurder")
    //анотація яка викликає запрос до сайту "SceneOfTheMurder"
    public String getSceneOfTheMurder(@ModelAttribute("") Character character) {
        return "SceneOfTheMurder";
    }

    @GetMapping("/location")
    public String getCharacter(@ModelAttribute("location") String location) throws IOException {
        System.out.println("some=" + location);
        //redirectAttributes.addFlashAttribute( "character", currentCharacter);
//
        //return new ModelAndView("redirect:/character", (Map<String, ?>) model);
        return "location";
    }
}
