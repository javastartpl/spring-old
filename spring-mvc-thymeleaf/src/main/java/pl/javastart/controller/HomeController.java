package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("helloMessage", "Hello Thymeleaf!");
        model.addAttribute(
                "formArticle", 
                new Article("Some title", "Content here...", "tag1, tag2, ...")
                );
        return "index";
    }
}
