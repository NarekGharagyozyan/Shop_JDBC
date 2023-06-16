package am.myOffice.shopJDBC.repository.order.impl;

import am.myOffice.shopJDBC.model.Order;
import am.myOffice.shopJDBC.repository.order.OrderRepository;
import am.myOffice.shopJDBC.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final Connection connection;

    public OrderRepositoryImpl(DatabaseConnection databaseConnection) {
        this.connection = databaseConnection.getConnection();
        try {
            this.connection.createStatement().executeUpdate(
                    """
                            CREATE TABLE IF NOT EXISTS orders (
                            id bigserial primary key,
                            userId bigserial not null,
                            productId bigserial not null,
                            totalPrice double precision not null,
                            totalCountOfProduct int not null
                            )
                            """);
        } catch (SQLException e) {
            System.out.println("Connection exception");
        }
    }

    @Override
    public void create(Order order) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO orders (userId,productId,totalPrice,totalCountOfProduct) VALUES (?,?,?,?)"
        );
        preparedStatement.setLong(1, order.getUserId());
        preparedStatement.setLong(2, order.getProductId());
        preparedStatement.setDouble(3, order.getTotalPrice());
        preparedStatement.setInt(4, order.getTotalCountOfProduct());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Order order) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE orders SET userId = ?, productId = ?, totalPrice = ?, totalCountOfProduct = ? WHERE id = ?"
        );

        preparedStatement.setLong(1, order.getId());
        preparedStatement.setLong(2, order.getProductId());
        preparedStatement.setDouble(3, order.getTotalPrice());
        preparedStatement.setInt(4, order.getTotalCountOfProduct());
        preparedStatement.setLong(5, order.getId());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public Order getOrderById(Long id) throws SQLException {
        Order order = new Order();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from orders WHERE userId = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            setOrderFields(order, resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return order;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> ordersList = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * from orders");
        addProductToListFromResultSet(ordersList, resultSet);
        return ordersList;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from orders WHERE id = ?");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void setOrderFields(Order order, ResultSet resultSet) throws SQLException {
        order.setId(resultSet.getLong("id"));
        order.setUserId(resultSet.getLong("userId"));
        order.setProductId(resultSet.getLong("productId"));
        order.setTotalPrice(resultSet.getDouble("totalPrice"));
        order.setTotalCountOfProduct(resultSet.getInt("totalCountOfProduct"));
    }

    private void addProductToListFromResultSet(List<Order> ordersList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Order order = new Order();
            setOrderFields(order, resultSet);
            ordersList.add(order);
        }
    }
}
