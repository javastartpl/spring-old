package pl.javastart.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.constraint.group.Draft;
import pl.javastart.constraint.group.Full;
import pl.javastart.model.Project;

@Service
public class ProjectService {
    
    private Validator validator;
    
    @Autowired
    public ProjectService(Validator validator) {
        this.validator = validator;
    }

    public boolean validateDraft(Project project) {
        Set<ConstraintViolation<Project>> errors = validator.validate(project, Draft.class);
        errors.forEach(err -> System.out.println(err.getPropertyPath() + " " + err.getMessage()));
        return errors.isEmpty()? true : false;
    }
    
    public boolean validateFull(Project project) {
        Set<ConstraintViolation<Project>> errors = validator.validate(project, Full.class);
        errors.forEach(err -> System.out.println(err.getPropertyPath() + " " + err.getMessage()));
        return errors.isEmpty()? true : false;
    }
}
