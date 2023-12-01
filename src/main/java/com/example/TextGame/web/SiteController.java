package com.example.TextGame.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SiteController {

        @GetMapping("/main") //анотація яка викликає запрос до сайту "main"
        public String getMain() {
            return "main";
        }

        //@GetMapping("/Describe") //анотація яка викликає запрос до сайту "Describe"
        public String getDescribe() {
            return "Describe";
        }

        @GetMapping("/SceneOfTheMurder") //анотація яка викликає запрос до сайту "SceneOfTheMurder"
        public String getSceneOfTheMurder() {
            return "SceneOfTheMurder";
        }


    //@GetMapping("/character") //анотація яка викликає запрос до сайту "SceneOfTheMurder"
    public String character() {
        return "character";
    }

        @GetMapping("/Book") //анотація яка викликає запрос до сайту "Book"
        public String getBook() {
            return "Book";
        }

        @GetMapping("/Killer") //анотація яка викликає запрос до сайту "Killer"
        public String getKiller(Model model) {
            model.addAttribute("characterNumber", "characterNumber");
            return "Killer";
        }

        @GetMapping("/Body") //анотація яка викликає запрос до сайту "Body"
        public String getBody() {
            return "Body";
        }

        @GetMapping("/Table") //анотація яка викликає запрос до сайту "Table"
        public String getTable() {
            return "Table";
        }

        @GetMapping("/Floor") //анотація яка викликає запрос до сайту "Floor"
        public String getFloor() {
            return "Floor";
        }

        @GetMapping("/End") //анотація яка викликає запрос до сайту "End"
        public String getEnd() {
            return "End";
        }

        @GetMapping("character1") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter1() {
            return "character1";
        }

        @GetMapping("character2") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter2() {
            return "character2";
        }

        @GetMapping("character3") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter3() {
            return "character3";
        }

        @GetMapping("character4") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter4() {
            return "character4";
        }

        @GetMapping("character5") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter5() {
            return "character5";
        }

        @GetMapping("character6") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter6() {
            return "character6";
        }

        @GetMapping("character7") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter7() {
            return "character7";
        }

        @GetMapping("character8") //анотація яка викликає запрос до сайту "character1"
        public String getcharacter8() {
            return "character8";
        }

        @GetMapping("/Victory") //анотація яка викликає запрос до сайту "Victory"
        public String getGood() {return "Victory";}

        @GetMapping("/Loss") //анотація яка викликає запрос до сайту "Loss"
        public String getLoss() {
            return "Loss";
        }
    }

