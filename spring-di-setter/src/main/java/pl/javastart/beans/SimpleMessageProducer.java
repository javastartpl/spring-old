package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("simpleMessageProducer")
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}

}
