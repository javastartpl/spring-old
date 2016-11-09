package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.javastart.model.Book;
import pl.javastart.service.BookRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopApplication {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringAopApplication.class);
		
		BookRepository repo = ctx.getBean(BookRepository.class);
		repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
		repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
		repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
//		repo.add(null);
    Book book = repo.get("1234567890123"); //found
    System.out.println(book);
    Book book2 = repo.get("1234567890129"); //not found
    System.out.println(book2);
    
		ctx.close();
	}
}