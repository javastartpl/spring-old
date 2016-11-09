package pl.javastart.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("within(pl.javastart.beans.*)")
    public void beforeMyBean() {
        System.out.println("Before my bean");
    }
    
}
