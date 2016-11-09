package pl.javastart.config;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource("classpath:appConfig.properties")
public class AppConfig {

	@Bean
	@Qualifier("randomNumber")
	public int getRandomNumber() {
		return new Random().nextInt();
	}
//	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer 
//					getPropertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
}