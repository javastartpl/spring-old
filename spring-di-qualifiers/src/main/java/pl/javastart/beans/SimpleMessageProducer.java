package pl.javastart.beans;

import org.springframework.stereotype.Component;

import pl.javastart.beans.Message.MessageType;

@Component
//@Qualifier("simpleMessageProducer")
@Message(type = MessageType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}

}
