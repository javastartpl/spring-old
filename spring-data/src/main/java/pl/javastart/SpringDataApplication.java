package pl.javastart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.model.Car;
import pl.javastart.repository.CarRepository;

@Configuration
@ComponentScan
public class SpringDataApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(SpringDataApplication.class);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        
        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //zapisujemy samochody
        
        Car firstCar = carRepo.findOne(1L); //pobieramy pierwszy
        carRepo.delete(firstCar); //usuwamy go
        
        //pobieramy i wyœwietlamy pozosta³e
        carRepo.findAll().forEach(System.out::println);
        
        ctx.close();
    }
}