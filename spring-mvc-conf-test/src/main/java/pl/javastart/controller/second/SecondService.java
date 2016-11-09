package pl.javastart.controller.second;

import org.springframework.stereotype.Component;

import pl.javastart.config.SomeComponent;

@Component
@SomeComponent
public class SecondService {
    public String getMessage() {
        return "Second message";
    }
}
