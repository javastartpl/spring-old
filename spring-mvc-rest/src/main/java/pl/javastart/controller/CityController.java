package pl.javastart.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping("/city")
    public String getCity(HttpServletResponse resp) {
        return "{name: Warszawa, population: 170000}";
    }
}
