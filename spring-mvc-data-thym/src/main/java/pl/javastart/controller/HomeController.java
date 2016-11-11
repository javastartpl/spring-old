package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.model.TimeData;

@Controller
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("timeData", new TimeData());
        return "index";
    }
    
}
