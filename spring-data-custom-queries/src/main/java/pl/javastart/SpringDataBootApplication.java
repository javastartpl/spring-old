package pl.javastart;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.model.Employee;
import pl.javastart.repository.EmployeeRepository;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = 
                SpringApplication.run(SpringDataBootApplication.class, args);

        EmployeeRepository employeeRepo = ctx.getBean(EmployeeRepository.class);
        
        Stream.of(new Employee("Jan", "Kowalski", 3000.0),
                new Employee("Wojciech", "Kowalski", 4000.0),
                new Employee("Ania", "Zawada", 3200.0),
                new Employee("Patryk", "Kostrzewski", 4500.0))
        .forEach(employeeRepo::save);

        System.out.println("Employees with last name Kowalski and salary >= 2000");
        employeeRepo.findByLastNameAndSalary("Kowalski", 2000)
        .forEach(System.out::println);
        
        System.out.println("Employee names with salary >= 4000");
        employeeRepo.namesForSalaryAsc(4000)
        .forEach(System.out::println);
        
        ctx.close();
    }
}