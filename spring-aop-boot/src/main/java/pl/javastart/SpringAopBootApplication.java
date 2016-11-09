package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.javastart.service.ExampleRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringAopBootApplication.class, args);
		ExampleRepository bean = ctx.getBean(ExampleRepository.class);
		bean.doSomething();
		ctx.close();
	}
}
