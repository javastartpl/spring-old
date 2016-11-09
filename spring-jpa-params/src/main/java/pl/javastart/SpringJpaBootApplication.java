package pl.javastart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.ProductDao;
import pl.javastart.model.Product;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Telewizor", "Samsung", 4500.0));
        products.add(new Product("Opiekacz", "Opiex", 120.0));
        products.add(new Product("Laptop", "Samsung", 3599.0));
        products.add(new Product("Kino domowe", "Yamaha", 2600.0));
        products.add(new Product("Smartfon", "Sony", 2100.0));
        
        ProductDao productDao = ctx.getBean(ProductDao.class);
        products.forEach(productDao::save);
        
        productDao.deleteByProducer("Samsung");
        System.out.println("Products without Samsung:");
        productDao.getAll().forEach(System.out::println);

        System.out.println("Opiekacze:");
        List<Product> productByName = productDao.getByName("Opiekacz");
        System.out.println(productByName);
        
        ctx.close();
    }
}