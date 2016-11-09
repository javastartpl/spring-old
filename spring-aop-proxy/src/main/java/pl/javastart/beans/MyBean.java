package pl.javastart.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean implements MyInterface{
    
    public void doAction() {
        System.out.println("Inside doAction()");
    }
    
}
