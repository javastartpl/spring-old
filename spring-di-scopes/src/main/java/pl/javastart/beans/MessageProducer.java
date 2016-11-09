package pl.javastart.beans;

import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageProducer {
    
    private int number;
    
    public MessageProducer() {
        number = new Random().nextInt();
    }

    public int getNumber() {
        return number;
    }
}
