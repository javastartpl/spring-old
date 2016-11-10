package pl.javastart.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.javastart.model.Book;

@Controller
public class AppController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("book", new Book());
        return "home";
    }
    
    @GetMapping("/if")
    public String ifExample(Model model) {
        model.addAttribute("text", "Sample Text");
        model.addAttribute("a", 123);
        model.addAttribute("b", 456);
        return "if";
    }
    
    @GetMapping("/loop")
    public String loopExample(Model model) {
        model.addAttribute("books",Arrays.asList(
                new Book("Książka 1", "Autor 1", 59.99),
                new Book("Książka 2", "Autor 2", 69.99),
                new Book("Książka 3", "Autor 3", 79.99),
                new Book("Książka 4", "Autor 4", 89.99),
                new Book("Książka 5", "Autor 5", 99.99),
                new Book("Książka 6", "Autor 6", 19.99)
                ));
        return "loop";
    }
    
    @PostMapping("/bookadd")
    public String bookAdd(@ModelAttribute Book book, Model model) {
        model.addAttribute("message", "Book " + book + " added!");
        return "home";
    }
}