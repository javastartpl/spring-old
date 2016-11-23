package pl.javastart.service;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.model.Person;

@Service
public class PersonService {
    
    private Set<Person> people;
    
    private Validator validator;
    
    @Autowired
    public PersonService(Validator validator) {
        this.validator = validator;
        this.people = new HashSet<>();
    }
    
    public void addPerson(Person person) {
        Set<ConstraintViolation<Person>> errors = validator.validate(person);
        if(!errors.isEmpty()) {
            for(ConstraintViolation<Person> cv: errors) {
                System.err.println(cv.getMessage());
            }
        } else {
            people.add(person);
        }
    }
    
    public Set<Person> getPeople() {
        return this.people;
    }
}
