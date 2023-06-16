package am.myOffice.shopJDBC.repository.order;

import am.myOffice.shopJDBC.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {


    void create(Order order) throws Exception;

    void update(Order order) throws SQLException;

    Order getOrderById(Long id) throws SQLException;

    List<Order> getAll() throws SQLException;

    void delete(Long id) throws SQLException;
}
