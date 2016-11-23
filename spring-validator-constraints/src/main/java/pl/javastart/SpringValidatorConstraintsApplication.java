package pl.javastart;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.javastart.model.User;

@SpringBootApplication
public class SpringValidatorConstraintsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringValidatorConstraintsApplication.class, args);
        User user = 
                new User(1, "Jan", "Kowalski", "jankowalski.pl", "http://kowalski.pl", new Date(1987, 11, 11),
                "12345678901");
        Validator validator = (Validator) ctx.getBean("validator");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(v -> System.out.println(v.getMessage()));
    }
    
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
