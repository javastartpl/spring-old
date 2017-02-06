package pl.javastart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecuredController {
    
    @RequestMapping("/")
    public String home(HttpSession session) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int a, @RequestParam int b) {
        System.out.println("a + b =" + (a + b));
        return "redirect:/";
    }
    
}