package service;

import model.Product;
import model.ProductView;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<Product> findAll();
    boolean edit( Product product);
    Product findById(int id);
    void delete(int id);

    Product create(Product product);

    Product findByName(String search);
}
