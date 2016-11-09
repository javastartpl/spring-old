package pl.javastart;

import java.util.List;
import org.springframework.context.annotation.*;
import pl.javastart.beans.NamesRepository;

@Configuration
@ComponentScan
public class SpringDiApplication {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringDiApplication.class);
		
		NamesRepository namesRepo= ctx.getBean(NamesRepository.class);
		List<String> allNames = namesRepo.getAll();
		allNames.forEach(System.out::println);
		
		ctx.close();
	}
}
