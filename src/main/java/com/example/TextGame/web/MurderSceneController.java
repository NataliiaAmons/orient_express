package com.example.TextGame.web;

import org.springframework.web.bind.annotation.GetMapping;

public class MurderSceneController {
    @GetMapping("/SceneOfTheMurder") //анотація яка викликає запрос до сайту "SceneOfTheMurder"
    public String getSceneOfTheMurder() {
        return "SceneOfTheMurder";
    }
}
