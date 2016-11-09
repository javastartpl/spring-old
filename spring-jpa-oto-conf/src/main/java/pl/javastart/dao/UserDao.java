package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.User;

@Repository
@Transactional
public class UserDao {
    
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void save(User user){
        entityManager.persist(user);
    }
    public User get(Long id) {
        return null;
    }
    public void update(User user) {
        
    }
    public void delete(User user) {
        
    }
    
}
