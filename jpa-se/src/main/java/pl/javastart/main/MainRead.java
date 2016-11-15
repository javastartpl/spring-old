package pl.javastart.main;

import pl.javastart.dao.BookDao;
import pl.javastart.dao.BookDaoImpl;
import pl.javastart.model.Book;

public class MainRead {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        Book book = bookDao.get(1L);
        System.out.println(book);
        bookDao.cleanUp();
    }
}
