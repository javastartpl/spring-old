package pl.javastart.service;

import org.springframework.stereotype.Component;

@Component
public class MyBean implements MyInterface {

    @Override
    public void myMethod() {
        System.out.println("My Method");
    }

}
