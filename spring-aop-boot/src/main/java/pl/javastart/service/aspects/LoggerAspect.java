package pl.javastart.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import pl.javastart.model.Book;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(public void add(..)) && args(book)")
    public void logInfo(JoinPoint joinPoint, Book book) {
        System.out.println("Log before " + joinPoint.getSignature() + book);
    }
    
    @After("execution(public void add(..))")
    public void logInfo(JoinPoint joinPoint) {
        System.out.println("Log before " + joinPoint.getSignature());
    }
    
    @AfterThrowing("execution(public void add(..))")
    public void logError(JoinPoint joinPoint) {
        System.out.println("Log before " + joinPoint.getSignature());
    }
    
    @AfterReturning("execution(public void add(..))")
    public void logSuccess(JoinPoint joinPoint) {
        System.out.println("Log before " + joinPoint.getSignature());
    }
}