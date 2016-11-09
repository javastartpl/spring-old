package pl.javastart.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import pl.javastart.model.Book;

@Repository
//@Transactional
public class BookDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    public void save(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
    }
    
//    @PersistenceContext
//    EntityManager em;
//    
//    public void save(Book book) {
//        em.persist(book);
//    }
    
}
