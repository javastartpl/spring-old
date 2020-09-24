package pl.javastart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    @Column(name="firstname", nullable=false)
    private String firstName;
    @Column(name="lastname", nullable=false)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();
    
    Client() {}
    
    public Client(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + firstName 
                + ", lastName=" + lastName + ", address=" + address
                + ",\n orders=" + orders + "]";
    }
}
