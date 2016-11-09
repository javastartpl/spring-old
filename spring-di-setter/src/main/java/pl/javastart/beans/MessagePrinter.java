package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	
	private MessageProducer producer;
	
	@Autowired
	@Qualifier("fileMessageProducer")
	public void setProducer(MessageProducer producer) {
		this.producer = producer;
	}
	
	public void print() {
		System.out.println(producer.getMessage());
	}
}
