package pl.javastart.main;

import pl.javastart.dao.BookDao;
import pl.javastart.dao.BookDaoImpl;
import pl.javastart.model.Book;

public class Main {
    public static void main(String[] args) {
        
        Book book = new Book("123456789", "Wilk z Wall Street", "Jordan Belfort");
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved");
        bookDao.cleanUp();
    }
}
