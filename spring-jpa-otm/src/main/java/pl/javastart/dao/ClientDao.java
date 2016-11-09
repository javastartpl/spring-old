package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Client;
import pl.javastart.model.Order;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

    public void addOrder(Client client, Order order) {
        //into managed state
        Client updateClient = getEntityManager().find(Client.class, client.getId());
        //persist order to avoid transient exception
        getEntityManager().persist(order);
        //just add order to collection, will be saved with transaction commit - 
        //method execution
        updateClient.getOrders().add(order);
    }
    
    @Override
    public Client get(Long key) {
        Client client = super.get(key);
        //primitive solution for lazy loading
        client.getOrders().size();
        return client;
    }
}
