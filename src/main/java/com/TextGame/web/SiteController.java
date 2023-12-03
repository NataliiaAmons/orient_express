package com.TextGame.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SiteController {

        @GetMapping("/Killer") //анотація яка викликає запрос до сайту "Killer"
        public String getKiller(Model model) {
            model.addAttribute("characterNumber", "characterNumber");
            return "Killer";
        }
        @GetMapping("/End") //анотація яка викликає запрос до сайту "End"
        public String getEnd() {
            return "End";
        }
        @GetMapping("/Victory") //анотація яка викликає запрос до сайту "Victory"
        public String getGood() {return "Victory";}

        @GetMapping("/Confirmation") //анотація яка викликає запрос до сайту "Confirmation"
        public String getConfirmation() {
            return "Confirmation";
        }

        @GetMapping("/Loss") //анотація яка викликає запрос до сайту "Loss"
        public String getLoss() {
            return "Loss";
        }
}