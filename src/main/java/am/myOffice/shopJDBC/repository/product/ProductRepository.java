package am.myOffice.shopJDBC.repository.product;

import am.myOffice.shopJDBC.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {

    void create(Product product);
    void update(Product product, Long id) ;

    Product get(Long id);
    List<String> getColumns();

    List<Product> getAll();

    List<Product> findProductsByName(String name) throws SQLException;

    void delete(Long id);

}
