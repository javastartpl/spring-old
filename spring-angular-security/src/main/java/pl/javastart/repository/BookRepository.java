package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.javastart.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
