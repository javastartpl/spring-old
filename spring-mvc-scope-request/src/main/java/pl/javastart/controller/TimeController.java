package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.component.TimeComponent;

@Controller
public class TimeController {

    private TimeComponent timeComponent;
    
    @Autowired
    public TimeController(TimeComponent timeComponent) {
        this.timeComponent = timeComponent;
    }

    @GetMapping("/time")
    public String printTime() {
        System.out.println(timeComponent.getTime());
        return "index.jsp";
    }
}