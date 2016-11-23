package pl.javastart;

import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.javastart.model.Person;
import pl.javastart.service.PersonService;

@SpringBootApplication
public class SpringValidatorBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringValidatorBootApplication.class, args);
        
        PersonService personService = ctx.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        personService.addPerson(person1);

        Person person2 = new Person("Anna", null, "zlyEmail", 0);
        personService.addPerson(person2);

        System.out.println("People " + personService.getPeople().size());
        for (Person p : personService.getPeople()) {
            System.out.println(p);
        }

        ctx.close();
    }
    
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}