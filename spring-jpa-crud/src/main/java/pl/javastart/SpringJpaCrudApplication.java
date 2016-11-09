package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@SpringBootApplication
public class SpringJpaCrudApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringJpaCrudApplication.class, args);

        // CREATE
        BookDao dao = ctx.getBean(BookDao.class);
        Book book = new Book("1234567890468", "Spring is so cool", "1Javastart");
        dao.save(book);

        // UPDATE
        Book book2 = new Book("987654321", "Spring is NOT so cool", "Javastart");
        book2.setId(1L);
        dao.update(book2);

        // READ
        Book findBook = dao.get(1L);
        System.out.println(findBook);

        // DELETE
        dao.remove(1L);
        Book book3 = dao.get(1L);
        System.out.println(book3); //null
    }
}
