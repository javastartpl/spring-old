package pl.javastart.beans.producers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.javastart.beans.producers.Producer.ProducerType;

@Component
@Producer(type = ProducerType.SIMPLE)
@Primary
public class SimpleMessageProducer implements MessageProducer {
	
	public SimpleMessageProducer() {
		System.out.println("Simple producer created");
	}
	
	@Override
	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}
}
