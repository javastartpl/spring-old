package pl.javastart.controller.first;

import org.springframework.stereotype.Component;

import pl.javastart.config.SomeComponent;

@Component
@SomeComponent
public class FirstService {
    
    public String getMessage() {
        return "First Message";
    }
}
