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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    DatabaseConnection databaseConnection;

    public OrderServiceImpl(OrderRepository orderRepository, DatabaseConnection databaseConnection) {
        this.orderRepository = orderRepository;
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void createOrder(Long userId, Long productId, int count) throws SQLException {

    ProductRepository productRepository = new ProductRepositoryImpl(databaseConnection);
    UserRepository userRepository = new UserRepositoryImpl(databaseConnection);

        var user = userRepository.get(userId);
        var product = productRepository.get(productId);

        try {
            orderRepository.create(user,product,count);
            System.out.println("Your order has been confirmed");

            double totalPrice = count * product.getPrice();
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(newBalance);

            userRepository.update(user);
            databaseConnection.getConnection().commit();
        } catch (Exception e){
            databaseConnection.getConnection().rollback();
            System.out.println("Your account doesn't have enough money!!!");
        }
    }
}
