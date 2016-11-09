package pl.javastart.config;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	@Qualifier("messageFile")
	public String configFileName() {
		return "/message.txt";
	}
	
	@Bean
	@Qualifier("randomNumber")
	public Integer simpleMessages() {
		return new Random().nextInt();
	}
}
