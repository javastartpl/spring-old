package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Order;
import pl.javastart.model.Product;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
    
    public void addProductsToOrder(Long orderId, Product... products) {
        Order order = get(orderId);
        for (Product product : products) {
            order.getProducts().add(product);
        }
    }
}