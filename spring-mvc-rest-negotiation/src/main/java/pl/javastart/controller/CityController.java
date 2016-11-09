package pl.javastart.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javastart.model.City;

@RestController
public class CityController {

//    @RequestMapping(path = "/city")
//    public City getCity() {
//        return new City("Warszawa", 1_700_000);
//    }
    
      @RequestMapping(path = "/city", 
              produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
      public City getCity() {
          return new City("Warszawa", 1_700_000);
      }
}
