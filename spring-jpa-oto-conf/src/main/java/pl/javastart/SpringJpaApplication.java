package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.dao.UserDao;
import pl.javastart.model.User;

@Configuration
@ComponentScan
public class SpringJpaApplication {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(SpringJpaApplication.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("asd", "dsa", "zxc");
        userDao.save(user);
        userDao.get(1L);
        //zapisujemy
        ctx.close();
    }
}