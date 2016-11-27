package pl.javastart.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.model.Person;
import pl.javastart.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository repository;
    
    @Autowired
    public PersonService(PersonRepository personRepository) {
        repository = personRepository;
    }
    
    public void add(Person person) {
        try {
            repository.add(person);
        } catch(ConstraintViolationException e) {
            Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
            errors.forEach(err -> System.err.println(
                    err.getPropertyPath() + " " +
                    err.getInvalidValue() + " " + 
                    err.getMessage()));
        }
    }
}
