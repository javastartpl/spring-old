package pl.javastart;

import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.javastart.model.Message;
import pl.javastart.service.MessageService;

@SpringBootApplication
public class SpringValidatorCustomConstraintsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
		        SpringApplication.run(SpringValidatorCustomConstraintsApplication.class, args);
		MessageService msgService = ctx.getBean(MessageService.class);
		Message msg = new Message("Hello message", "Cholercia to brzydkie słowo");
		boolean verifyMessage = msgService.verifyMessage(msg);
		System.out.println("Wiadomość poprawma? " + verifyMessage);
		ctx.close();
	}
	
	@Bean
	public Validator validator() {
	    return new LocalValidatorFactoryBean();
	}
}
