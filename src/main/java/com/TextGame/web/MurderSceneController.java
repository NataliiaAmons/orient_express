package com.TextGame.web;

import com.TextGame.domain.Evidence;
import com.TextGame.service.CurrentSessionService;
import com.TextGame.dao.EvidenceRepository;
import com.TextGame.dao.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MurderSceneController {
    @Autowired
    private EvidenceRepository evidenceRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/SceneOfTheMurder")
    //анотація яка викликає запрос до сайту "SceneOfTheMurder"
    public String getSceneOfTheMurder() {
        System.out.println("SceneOfTheMurder");
        return "SceneOfTheMurder";
    }

    @PostMapping("/location")
    public String getCharacter(@ModelAttribute("location") String location, Model model) throws IOException {
        System.out.println("some=" + location);
        ArrayList<Evidence> allEvidence = evidenceRepository.getAllEvidences();
        ArrayList<Evidence> evidence = new ArrayList<>();
        for(int i=0; i<allEvidence.size(); i++) {
            if (allEvidence.get(i).getLocation().equals(location)) {
                evidence.add(allEvidence.get(i));
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);
        for(int i=0; i<evidence.size(); i++) {
            userRepository.addEvidenceToFound(username, evidence.get(i).getNumber());
        }

        model.addAttribute("evidence", evidence);

        return "SceneOfTheMurder";
    }
}
