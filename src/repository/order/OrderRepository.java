package repository.order;

import model.Order;
import model.Product;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {


    void create(Order order) throws Exception;

    void update(Order order) throws SQLException;

    Order getOrderById(Long id) throws SQLException;

    List<Order> getAll() throws SQLException;

    void delete(Long id) throws SQLException;
}
