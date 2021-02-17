package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.UserDao;
import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
        
        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("johnny234", "strongPass", "johnny@gmail.com");
        //zapisujemy obiekt bez UserDetails
        userDao.save(user);
        
        //dodajemy szczegóły do obiektu
        UserDetails details = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setDetails(details);
        userDao.update(user);
        
        //aktualizujemy hasło oraz imię
        user.setPassword("passPass");
        user.getDetails().setFirstName("Piotr");
        userDao.update(user);
        
        //pobieramy aktualny stan obiektu z bazy i wyświetlamy
        User userFromDb = userDao.get(1L);
        System.out.println(userFromDb);
        
        //usuwamy obiekt z bazy
        userDao.delete(user);
        
        //ponownie pobieramy  aktualny stan obiektu z bazy i wyświetlamy
        userFromDb = userDao.get(1L);
        System.out.println(userFromDb);
        
        ctx.close();
    }
}