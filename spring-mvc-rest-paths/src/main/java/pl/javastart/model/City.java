package pl.javastart.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {
    
    private int id;
    private String name;
    private int population;
    
    City() {
    }
    
    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
}