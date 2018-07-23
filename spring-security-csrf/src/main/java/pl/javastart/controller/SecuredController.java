package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecuredController {
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(@RequestParam int a, @RequestParam int b) {
        return String.format("%d + %d = %d", a, b, (a+b));
    }
    
}