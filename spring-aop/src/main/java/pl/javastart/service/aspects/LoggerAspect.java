package pl.javastart.service.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    
    @Before("execution(* pl.javastart.service.BookRepository.*(..))")
    public void logInfoBefore() {
        System.out.println("Log before ");
    }
    
    @After("execution(* pl.javastart.service.BookRepository.*(..))")
    public void logInfoAfter() {
        System.out.println("Method executed ");
    }
    
    @AfterThrowing("execution(* pl.javastart.service.BookRepository.*(..))")
    public void logError() {
        System.out.println("Method finished with error ");
    }
    
    @AfterReturning("execution(* pl.javastart.service.BookRepository.*(..))")
    public void logSuccess() {
        System.out.println("Method successfully returned");
    }
}