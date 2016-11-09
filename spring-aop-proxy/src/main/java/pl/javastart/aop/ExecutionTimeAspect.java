package pl.javastart.aop;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    
    @Around("execution(public * *(..))")
    public void logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Berofre " + pjp.toShortString());
        Instant start = Instant.now();
        pjp.proceed();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        
        System.out.println("after " + pjp.toShortString() + " " + duration.toMillis());
    }
}