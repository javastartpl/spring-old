package pl.javastart.beans;

import org.springframework.stereotype.Component;

@Component
public class SimpleMessageProducer implements MessageProducer {
	@Override
	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}
}
