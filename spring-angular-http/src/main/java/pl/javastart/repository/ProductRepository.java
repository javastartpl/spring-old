package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.javastart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
