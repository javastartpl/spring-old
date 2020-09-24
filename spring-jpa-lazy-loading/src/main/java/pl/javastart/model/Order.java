package pl.javastart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT) //Hibernate, nie zadziała np. z EclipseLink
    @JoinTable(name = "order_products",
            joinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id_order") },
            inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id_product") })
    private List<Product> products = new ArrayList<>();
    @Column(name = "details", length = 512)
    private String orderDetails;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    Order() {
    }

    public Order(String orderDetails) {
        super();
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
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
        return "Order [id=" + id 
                + ", orderDetails=" + orderDetails 
                + ", client=" + client.getFirstName() + " " + client.getLastName()
                + ",\n products=" + products + "]";
    }
}
