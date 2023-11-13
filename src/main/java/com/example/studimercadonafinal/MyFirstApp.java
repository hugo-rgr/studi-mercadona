package com.example.studimercadonafinal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstApp {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hey!!!!");
        return "greeting";
    }


}
