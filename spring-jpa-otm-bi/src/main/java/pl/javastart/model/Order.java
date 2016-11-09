package pl.javastart.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_order")
    private Long id;
    @Column(nullable = false)
    private String product;
    @Column(name = "details", length = 512)
    private String orderDetails;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    Order() {}
    
    public Order(String product, String orderDetails) {
        this.product = product;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", product=" + product 
                + ", orderDetails=" + orderDetails + ", "
                + client.getFirstName() + " " +client.getLastName()+ "]";
    }
}