package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.beans.NamesRepository;

@SpringBootApplication
public class SpringDiBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDiBootApplication.class, args);
		NamesRepository repository = ctx.getBean(NamesRepository.class);
		repository.getAll().forEach(System.out::println);
		ctx.close();
	}
	
}
