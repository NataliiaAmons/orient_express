package com.example.TextGame.web;

import com.example.TextGame.dao.CharacterRepository;
import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.service.CurrentSessionService;
import com.example.TextGame.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserService userService;
    @Autowired
    public DialogController dialogController;
    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/") //shows login page
    public String main(Model model){

        model.addAttribute("user", "user name");
        model.addAttribute("itIsMe", false);
        return "main";
    }

    @PostMapping("/Describe") //lets user in if username is correct/available
    public String setUsername(Model model, @RequestParam("username") String username, @RequestParam("letIn") String letIn) throws IOException {//@ModelAttribute("user") User user){
        if (letIn.equals("false")) {

            String alert = userService.usernameAlert(username);
            if (alert != "") {
                boolean itIsMe = false;
                if (alert == "Це ім'я вже використовується. Ви впевнені що це були ви?") {
                    itIsMe = true;
                }
                model.addAttribute("alert", alert);
                model.addAttribute("itIsMe", itIsMe);
                model.addAttribute("letIn", "");
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                CurrentSessionService.addUsernameToSession(request, username);
                return "main";
            }
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String name = CurrentSessionService.getUsername(request);

            System.out.println("username:" + name);

            userService.createUserFiles(name);
            return "Describe";
        }


        else{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String name = CurrentSessionService.getUsername(request);
            System.out.println("username:" + name);

            return "Describe";}
    }


}
