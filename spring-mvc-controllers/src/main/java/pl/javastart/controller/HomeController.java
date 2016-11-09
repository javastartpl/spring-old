package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "Nieznajomy") String username,
                       @RequestParam(defaultValue = "0") int age, 
                       @RequestHeader("user-agent") String userAgent) {
        System.out.println("Hello " + username);
        if (age > 0) {
            System.out.println("Your age is: " + age);
        }
        System.out.println("Web browser: " + userAgent);
        return "home";
    }

}
