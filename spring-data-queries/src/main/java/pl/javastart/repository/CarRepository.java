package pl.javastart.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    
    //pierwszy samochód danej marki
    Car findFirstByBrand(String brand);
    
    //pierwszy samochód ze wskazaną ceną
    Car findFirstByPrice(double price);
    //Car findTopByPrice(double price);
    
    //pierwsze trzy samochody z bazy
    List<Car> findFirst3ByBrand(String brand);
    
    //samochody danej marki o wskazanej cenie
    List<Car> findAllByBrandAndPrice(String brand, double price);
    //samochody jednej z dwóch marek
    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    //samochody z marką określoną przez wzorzec, np. "A%" - rozpoczynające się od A
    List<Car> findAllByBrandLike(String pattern);
    //samochody o nazwach kończących się na wskazany ciąg znaków
    List<Car> findAllByNameEndingWith(String pattern);
    
    //samochody o cenach niższych od
    List<Car> findAllByPriceLessThan(double price);
    //samochody o cenie pomiędzy low i high
    List<Car> findAllByPriceBetween(double low, double high);
    
    //wszystkie samochody danego producenta z ceną rosnąco
    List<Car> findAllByBrandOrderByPriceAsc(String brand);
    
    //wszystkie samochody z ustawioną marką
    List<Car> findAllByBrandNotNull();
    //wszystkie samochody z nazwą należącą do kolekcji
    List<Car> findAllByNameIn(Collection<String> names);
}