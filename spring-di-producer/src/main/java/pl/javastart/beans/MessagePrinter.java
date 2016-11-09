package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pl.javastart.beans.Message.MessageType;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessagePrinter {
	
	@Autowired
	@Message(type = MessageType.SIMPLE)
	private MessageProducer producer;
	
	public void print() {
		System.out.println("Message produced: " + producer.getMessage());
	}
}
