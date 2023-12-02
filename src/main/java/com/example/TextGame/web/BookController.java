package com.example.TextGame.web;

import com.example.TextGame.domain.Evidence;
import com.example.TextGame.service.BookService;
import com.example.TextGame.service.CurrentSessionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    public String getBookEvidence(Model model) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = CurrentSessionService.getUsername(request);
        ArrayList<Evidence> bookevidence = bookService.getFoundEvidence(username);
        model.addAttribute("evidence", bookevidence);
        return "book";


    }

}
