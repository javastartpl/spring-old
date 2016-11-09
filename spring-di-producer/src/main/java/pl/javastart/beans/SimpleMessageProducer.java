package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.javastart.beans.Message.MessageType;

@Component
//@Qualifier("simpleMessageProducer")
@Message(type = MessageType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

	@Autowired
	@Qualifier("randomNumber")
	private Integer random;
	
	@Override
	public String getMessage() {
		return "Simple Message: " + this + "  :  "+ random;
	}

}
