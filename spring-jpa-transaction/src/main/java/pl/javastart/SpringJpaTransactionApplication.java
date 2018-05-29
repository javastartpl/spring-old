package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@SpringBootApplication
public class SpringJpaTransactionApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaTransactionApplication.class, args);
		BookDao dao = ctx.getBean(BookDao.class);
		Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
		dao.save(book);
		Book book2 = dao.get(1L);
		System.out.println(book2);
		Thread.sleep(5000);
	}
}
