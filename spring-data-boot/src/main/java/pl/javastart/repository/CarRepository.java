package pl.javastart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    
}
