package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

//    @PersistenceUnit
//    private EntityManagerFactory emFactory;

    @PersistenceContext
    EntityManager entityManager;
    
    BookDaoImpl() {
    }

    @Override
    @Transactional
    public void save(Book book) {
//        EntityManager entityManager = emFactory.createEntityManager();
        System.out.println(entityManager);
        entityManager.persist(book);
    }

    @Override
    public Book get(Long id) {
//        EntityManager entityManager = emFactory.createEntityManager();
//        Book book = entityManager.find(Book.class, id);
//        entityManager.close();
//        return book;
        return null;
    }

}
