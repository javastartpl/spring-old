package pl.javastart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import pl.javastart.model.Car;
import pl.javastart.repository.CarRepository;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A5", "Audi", 49000.0));
        cars.add(new Car("Auris2", "Toyota", 35000.0));
        cars.add(new Car("Insignia2", "Opel", 29500.0));
        
        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //zapisujemy samochody
        
        Page<Car> carList = carRepo.findAll(new PageRequest(2, 2));
        carList.getContent().forEach(System.out::println);
        
        ctx.close();
    }
}