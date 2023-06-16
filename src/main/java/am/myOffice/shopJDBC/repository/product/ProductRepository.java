package am.myOffice.shopJDBC.repository.product;

import am.myOffice.shopJDBC.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {

    void create(Product product) throws SQLException;
    void update(Product product, Long id) throws Exception;

    Product get(Long id) throws Exception;

    List<Product> getAll() throws SQLException;

    List<Product> findProductsByName(String name) throws SQLException;

    void delete(Long id) throws Exception;

}
