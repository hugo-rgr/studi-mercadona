package com.example.studimercadonafinal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hey!!!!");
        return "greeting";
    }

    @GetMapping("/admin-dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
