package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	
	@Autowired
	@Qualifier("simpleMessageProducer")
	private MessageProducer producer;
	
	public void print() {
		System.out.println(producer.getMessage());
	}
}
