package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    void update(Book book);
    void remove(Long bookId);
}
