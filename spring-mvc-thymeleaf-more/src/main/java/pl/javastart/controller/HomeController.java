package pl.javastart.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("a", 4);
        model.addAttribute("b", 4);
        model.addAttribute("firstName", "Ela");
        model.addAttribute("names", Arrays.asList("ania", "kasia", "basia"));
        return "index";
    }
    
}
