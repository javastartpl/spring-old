package pl.javastart.model;

import javax.validation.constraints.Min;

import pl.javastart.constraint.Divided;

public class NumberBean {

    @Divided(by = 3)
    @Min(value = 3)
    private Integer number;
    
    public NumberBean(Integer number) {
        this.number = number;
    }
    
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
}