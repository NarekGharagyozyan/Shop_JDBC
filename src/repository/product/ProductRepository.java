package repository.product;

import model.Product;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {

    void create(Product product) throws SQLException;
    void update(Product product) throws SQLException;

    Product get(Long id) throws SQLException;

    List<Product> getAll() throws SQLException;

    List<Product> findProductsByName(String name) throws SQLException;

    void delete(Long id) throws SQLException;

}
