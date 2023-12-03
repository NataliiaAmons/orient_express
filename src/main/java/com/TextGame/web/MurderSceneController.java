package com.TextGame.web;

import com.TextGame.service.CurrentSessionService;
import com.TextGame.dao.EvidenceRepository;
import com.TextGame.dao.UserRepository;
import com.TextGame.service.MurderSceneService;
import com.TextGame.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MurderSceneController {
    @Autowired
    private EvidenceRepository evidenceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MurderSceneService murderSceneService;
    @Autowired
    private CurrentSessionService currentSessionService;

    public MurderSceneController() {
    }

    @GetMapping("/SceneOfTheMurder")
    public String getSceneOfTheMurder(Model model) throws IOException {
        ArrayList<Location> locations = murderSceneService.getLocations(0);
        model.addAttribute("locations", locations);
        return "SceneOfTheMurder";
    }

    @PostMapping("/location")
    public String getCharacter(@ModelAttribute("locationNumber") String locationNumber, @ModelAttribute("text") String text, Model model) throws IOException {
        murderSceneService.getAnswerModel(Integer.valueOf(locationNumber), text, model);
        return "SceneOfTheMurderLocation";
    }



}
