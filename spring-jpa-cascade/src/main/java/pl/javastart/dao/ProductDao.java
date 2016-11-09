package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
}
