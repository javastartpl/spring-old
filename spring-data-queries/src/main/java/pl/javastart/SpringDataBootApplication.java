package pl.javastart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.model.Car;
import pl.javastart.repository.CarRepository;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("A5", "Audi", 67000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A8", "Audi", 28000.0));
        cars.add(new Car("Corolla", "Toyota", 31000.0));
        cars.add(new Car("Vectra", "Opel", 29500.0));
        cars.add(new Car("Astra", "Opel", 29500.0));
        
        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //zapisujemy samochody
        
        //Find all
        System.out.println("All Toyota cars:");
        List<Car> allToyotas = carRepo.findByBrand("Toyota");
        allToyotas.forEach(System.out::println);
        
        //Find first
        Car opel = carRepo.findFirstByBrand("Opel");
        System.out.println(opel);
        
        //And / Or
        System.out.println("Audi for 49000: ");
        carRepo.findAllByBrandAndPrice("Audi", 49000).forEach(System.out::println);
        System.out.println("Toyota or Opel:");
        carRepo.findAllByBrandOrBrand("Toyota", "Opel").forEach(System.out::println);
        
        //like, notlike, startingwith, endingwith, containing
        System.out.println("Cars with brand starting with A");
        carRepo.findAllByBrandLike("A%").forEach(System.out::println);
        System.out.println("Cars with name ending with 'tra'");
        carRepo.findAllByNameEndingWith("tra").forEach(System.out::println);
        
        //lessThan, between
        System.out.println("Cars cheaper than 30000");
        carRepo.findAllByPriceLessThan(30000).forEach(System.out::println);
        System.out.println("Cars with price between 30-40k");
        carRepo.findAllByPriceBetween(30000, 40000).forEach(System.out::println);
        
        //ordering
        System.out.println("All Audi cars, price ascending");
        carRepo.findAllByBrandOrderByPriceAsc("Audi")
            .forEach(System.out::println);
        
        //notNull, in
        System.out.println("Cars with brand");
        carRepo.findAllByBrandNotNull().forEach(System.out::println);
        System.out.println("Car name in {Insignia, Corolla}");
        List<String> carNames = Stream.of("Insignia", "Corolla").collect(Collectors.toList());
        carRepo.findAllByNameIn(carNames).forEach(System.out::println);

        ctx.close();
    }
}