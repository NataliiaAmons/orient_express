package com.example.TextGame.web;

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

    @GetMapping("/")
    public String main(Model model){

        model.addAttribute("user", "user name");
        return "main";
    }

    //@GetMapping("/")
    public String setUsername() throws IOException {//@ModelAttribute("user") User user){
        //String username = user.getUsername();

        String username = "info";
        try{
            userService.checkIfUsernameIsAvailable(username);
        }
        catch(IOException e){}
        finally {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            CurrentSessionService.addUsernameToSession(request, username);
            String name = CurrentSessionService.getUsername(request);
            userService.createUserFiles(name);
            return "Describe";
        }
    }
    @PostMapping("/Describe")
    public String sdf(Model model, @RequestParam("username") String username) throws IOException {
        model.addAttribute("message", "Hello Spring MVC Framework!");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        CurrentSessionService.addUsernameToSession(request, username);
        String name = CurrentSessionService.getUsername(request);
        userService.createUserFiles(username);

        System.out.println("username saved: " +username );
        return"Describe";
    }
    @PostMapping("/error")
    public String sdsf(Model model,@RequestParam String sourceText) {
        return"Describe";
    }

}
