package pl.javastart;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;

import javax.validation.Validation;
import javax.validation.Validator;

@SpringBootApplication
public class SpringValidatorMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidatorMvcApplication.class, args);
	}


	@Bean
	public MessageSource validationMessageResource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public Validator validator() {
		return Validation.byDefaultProvider()
				.configure()
				.messageInterpolator(
						new ResourceBundleMessageInterpolator(
								new MessageSourceResourceBundleLocator(validationMessageResource())
						)
				)
				.buildValidatorFactory()
				.getValidator();
	}
}
