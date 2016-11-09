package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.beans.MessagePrinter;

@SpringBootApplication
public class SpringDiProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDiProducerApplication.class, args);
		MessagePrinter bean = ctx.getBean(MessagePrinter.class);
		bean.print();
		bean = ctx.getBean(MessagePrinter.class);
		bean.print();

	}
}
