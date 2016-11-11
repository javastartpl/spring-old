package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
}
