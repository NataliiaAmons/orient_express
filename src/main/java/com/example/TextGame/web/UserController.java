package com.example.TextGame.web;

import com.example.TextGame.dao.UserRepository;
import com.example.TextGame.domain.User;
import com.example.TextGame.service.CurrentSessionService;
import com.example.TextGame.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserService userService;

    //@GetMapping("/")
    public String main(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "main";
    }

    @GetMapping("/")
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
   // @GetMapping("/Describe")
    public String sdf(){
        return "Describe";
    }

}
