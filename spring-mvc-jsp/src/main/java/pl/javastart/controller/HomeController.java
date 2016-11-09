package pl.javastart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, ModelMap map) {
        request.setAttribute("message", "Hello in Spring WebApp!");
        return "home.jsp";
    }
    
}
