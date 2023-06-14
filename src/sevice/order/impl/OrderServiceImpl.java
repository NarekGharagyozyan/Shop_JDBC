package sevice.order.impl;

import model.Order;
import model.Product;
import model.User;
import repository.order.OrderRepository;
import repository.order.impl.OrderRepositoryImpl;
import repository.product.ProductRepository;
import repository.product.impl.ProductRepositoryImpl;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryImpl;
import sevice.order.OrderService;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DatabaseConnection databaseConnection;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            DatabaseConnection databaseConnection,
                            ProductRepository productRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.databaseConnection = databaseConnection;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createOrder(Long userId, Long productId, int count) throws SQLException {

        var connection = databaseConnection.getConnection();
        try {
            connection.setAutoCommit(false);

            var user = userRepository.get(userId);
            var product = productRepository.get(productId);
            var totalPrice = count * product.getPrice();
            Order order = new Order(userId, productId, totalPrice, count);

            orderRepository.create(order);
            var newBalance = user.getBalance() - totalPrice;
            user.setBalance(newBalance);
            userRepository.update(user);

            if (user.getBalance() < 0)
                throw new Exception("Your account doesn't have enough money!!!");
            System.out.println("Your order has been confirmed");

            connection.commit();
        } catch (Exception e){
            connection.rollback();
            System.out.println("Your account doesn't have enough money!!!");
        }
    }
}
