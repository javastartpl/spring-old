package pl.javastart.service.aspects;

import java.time.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("execution(* pl.javastart.service.BookRepository.*(..))")
    public Object measureExecTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant before = Instant.now();
        // @Before
        try {
            Object result = pjp.proceed();
            // @After
            return result;
        //}catch (Throwable e) {
        //  @AfterThrowing, gdyby nie by³o throws
        //}
        } finally {
         // @AfterReturning
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
    }
}