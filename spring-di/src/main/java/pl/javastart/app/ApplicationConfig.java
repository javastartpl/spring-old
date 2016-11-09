package pl.javastart.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.javastart.beans.MessagePrinter;
import pl.javastart.beans.MessageProducer;
import pl.javastart.beans.SimpleMessageProducer;

@Configuration
public class ApplicationConfig {

	@Bean(name = "myMessagePrinter")
	public MessagePrinter getPrinter() {
		MessageProducer producer = new SimpleMessageProducer();
		return new MessagePrinter(producer);
	}
}
