package pl.javastart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    @ResponseBody
    public String home(Model model) {
        return "Hello Spring Security with Spring Boot!";
    }
}