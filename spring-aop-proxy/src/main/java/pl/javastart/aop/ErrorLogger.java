package pl.javastart.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLogger {
    
//    @Before("execution(public * *(..))")
    @AfterThrowing(pointcut="execution(public * *(..))", throwing="ex")
    public void logError(JoinPoint jp, Exception ex) {
        System.err.printf("Exce %s [%s] \n", jp.toLongString(), ex.getMessage());
    }
    
}
