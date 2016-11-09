package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.data.BookDao;
import pl.javastart.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
        
        for(int i=0; i<1000; i++) {
            Book book = new Book(Integer.toString(i), "Jakiœ tytu³"+i, "Jakiœ autor"+i);
            BookDao bookDao = ctx.getBean(BookDao.class);
            bookDao.save(book);
        }
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ctx.close();
    }

}