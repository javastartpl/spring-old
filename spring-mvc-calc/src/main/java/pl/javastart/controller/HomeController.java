package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @PostMapping("/")
    public String calculate(@RequestParam(defaultValue = "0") int valueA,
                            @RequestParam(defaultValue = "0") int valueB) {
        int result = valueA + valueB;
        System.out.printf("%d + %d = %d\n", valueA, valueB, result);
        return "index";
    }
}