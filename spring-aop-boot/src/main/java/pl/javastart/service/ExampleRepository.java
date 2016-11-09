package pl.javastart.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ExampleRepository {
    
    public void add(String example) {
        randomPause();
        System.out.println("Object saved " + example);
    }
    
    public String get(Long id) {
        randomPause();
        System.out.println("Object get " + id);
        return "Object " + id;
    }
    
    private void randomPause() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void doSomething() {
        System.out.println("Something");
    }
}
