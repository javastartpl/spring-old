package pl.javastart.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.model.Message;

@Service
public class MessageService {

    private Validator validator;

    @Autowired
    public MessageService(Validator validator) {
        this.validator = validator;
    }
    
    public boolean verifyMessage(Message msg) {
        Set<ConstraintViolation<Message>> errors = validator.validate(msg);
        if(!errors.isEmpty()) {
            errors.forEach(err -> System.out.println(err.getMessage()));
            return false;
        } else {
            return true;
        }
    }
}
