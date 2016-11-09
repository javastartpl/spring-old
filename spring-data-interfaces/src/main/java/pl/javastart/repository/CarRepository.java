package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
