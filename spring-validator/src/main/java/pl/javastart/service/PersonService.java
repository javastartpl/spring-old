package pl.javastart.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import pl.javastart.model.Person;

@Service
@PropertySource("classpath:error_messages.properties")
public class PersonService {
    
    private Set<Person> people;
    
    private Validator validator;
    
    @Autowired
    private Environment env;
    
    @Autowired
    public PersonService(Validator validator) {
        this.validator = validator;
        this.people = new HashSet<>();
    }
    
    public void addPerson(Person person) {
        Errors errors = new BeanPropertyBindingResult(person, "person");
        validator.validate(person, errors);
        if(errors.hasErrors()) {
            System.err.printf("There are errors(%d):\n", errors.getErrorCount());
            for(ObjectError err: errors.getAllErrors()) {
                System.err.println(env.getProperty(err.getCode()));
            }
        } else {
            people.add(person);
        }
    }
    
    public Set<Person> getPeople() {
        return this.people;
    }
}