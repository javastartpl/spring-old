package pl.javastart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("helloMessage", "Welcome in Spring security");
        return "home";
    }
}