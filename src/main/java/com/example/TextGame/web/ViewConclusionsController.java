package com.example.TextGame.web;

import com.example.TextGame.dao.ConclusionRepository;
import com.example.TextGame.domain.Conclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ViewConclusionsController {

   @Autowired
   private ConclusionRepository conclusionRepository;

   @GetMapping("/view")
   public String getConclusions(Model model) {
      try {
         ArrayList<Conclusion> allConclusions = conclusionRepository.getAllConclusion();
         model.addAttribute("conclusions", allConclusions);
      } catch (IOException e) {
         // Відповідна обробка винятку, наприклад, журнал і показ повідомлення про помилку.
         e.printStackTrace();
      }
      return "Loss";
   }
}
