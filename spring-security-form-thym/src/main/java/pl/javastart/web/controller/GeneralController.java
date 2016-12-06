package pl.javastart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/secret")
    public String secret() {
        return "secret";
    }
    
    @GetMapping("/loginform")
    public String loginForm() {
        return "login_form";
    }
}
