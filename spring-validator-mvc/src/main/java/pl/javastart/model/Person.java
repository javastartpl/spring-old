package pl.javastart.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Person {

    @NotEmpty(message = "{pl.javastart.model.Person.firstName.NotEmpty}")
    private String firstName;
    @NotEmpty(message = "{pl.javastart.model.Person.lastName.NotEmpty}")
    private String lastName;
    @Email(message = "{pl.javastart.model.Person.email.Email}")
    @NotEmpty(message = "{pl.javastart.model.Person.email.NotEmpty}")
    private String email;
    @Min(value = 1, message = "{pl.javastart.model.Person.age.Min}")
    private int age;
    
    public Person() {}
    public Person(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [firstName=" + firstName 
                + ", lastName=" + lastName 
                + ", email=" + email 
                + ", age=" + age + "]";
    }
}