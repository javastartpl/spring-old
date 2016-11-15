package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.javastart.model.Book;

public class BookDaoImpl implements BookDao {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public BookDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Book book) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
    }

    @Override
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
