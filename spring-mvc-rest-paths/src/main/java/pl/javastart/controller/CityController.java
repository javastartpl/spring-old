package pl.javastart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.javastart.model.City;

@RestController
@RequestMapping("/cities")
public class CityController {
    
    private final List<City> cities = Arrays.asList(
            new City(1, "Warszawa", 1_700_000), 
            new City(2, "Wroclaw", 1_200_000),
            new City(3, "Kraków", 1_500_000), 
            new City(4, "Poznań", 1_100_000));

    @RequestMapping
    public List<City> getCities(@RequestParam(defaultValue="name") String orderBy,
                                @RequestParam(defaultValue="1") int page) {
        List<City> citiesCopy = new ArrayList<>(cities);
        if("name".equals(orderBy)) {
            citiesCopy.sort(Comparator.comparing(City::getName));
        } else if("population".equals(orderBy)) {
            citiesCopy.sort(Comparator.comparing(City::getPopulation));
        }
        return citiesCopy;
    }

    @RequestMapping("/{id}")
    public City getCity(@PathVariable int id) {
        return cities.get(id);
    }
    
}
