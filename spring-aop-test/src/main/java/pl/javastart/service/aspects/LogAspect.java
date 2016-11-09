package pl.javastart.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Before("execution(public * *(..))")
    public void logInfoBefore() {
        System.out.println("Log before ");
    }
}