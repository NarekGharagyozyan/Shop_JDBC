package am.myOffice.shopJDBC;

import am.myOffice.shopJDBC.model.Product;
import am.myOffice.shopJDBC.model.User;
import am.myOffice.shopJDBC.repository.order.OrderRepository;
import am.myOffice.shopJDBC.repository.order.impl.OrderRepositoryImpl;
import am.myOffice.shopJDBC.repository.product.ProductRepository;
import am.myOffice.shopJDBC.repository.product.impl.ProductRepositoryImpl;
import am.myOffice.shopJDBC.repository.user.UserRepository;
import am.myOffice.shopJDBC.repository.user.impl.UserRepositoryImpl;
import am.myOffice.shopJDBC.sevice.order.OrderService;
import am.myOffice.shopJDBC.sevice.order.impl.OrderServiceImpl;
import am.myOffice.shopJDBC.sevice.user.UserService;
import am.myOffice.shopJDBC.sevice.user.impl.UserServiceImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {

//        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
//
//        UserRepository userRepository = new UserRepositoryImpl(databaseConnection);
//        ProductRepository productRepository = new ProductRepositoryImpl(databaseConnection);
//        OrderRepository orderRepository = new OrderRepositoryImpl(databaseConnection);
//
//        User user = new User(1L, "Gogo", "Khachatryan", 75000, "username1@gmail.com", "password1", 27);
//        User user2 = new User(2L, "Nini", "Harutyunyan", 28000, "username2@gmail.com", "password2", 29);
//        User user3 = new User(3L, "Hoso", "Parunakyan", 19000, "username3@gmail.com", "password3", 23);
//
//        Product product = new Product(1L,"Bread", 250, "Grocery", true);
//        Product product2 = new Product(2L,"Iphone",450000,"Electronic", false);
//
//
//        OrderService orderService = new OrderServiceImpl(orderRepository,databaseConnection,productRepository,userRepository);
//        orderService.createOrder(user3.getId(),product.getId(),2);
//
//        //----------PRODUCTS-------------
//        /*//CREATE product
//        productRepository.create(product2);*/
//
//
//        /*//UPDATE product
//        productRepository.get(1L);
//        productRepository.update(product);
//        productRepository.get(1L);*/
//
//
//        /*//GET product
//        Product product1 = productRepository.get(1L);
//        System.out.println(product1);*/
//
//
//        /*//GET all products
//        for (Product product1 : productRepository.getAll()) {
//            System.out.println(product1);
//        }*/
//
//
//        /*//find product by name
//        List<Product> iphone = productRepository.findProductsByName("Iphone");
//        for (Product product1 : iphone) {
//            System.out.println(product1);
//        }*/
//
//        /*//DELETE product by index
//        productRepository.delete(1L);*/
//
//
//
//        //-------USERS----------
//        UserService userService = new UserServiceImpl(userRepository);
//
//        //userService.register(user3);
//        //userService.login("username2@gmail.com", "password2");
//
//
//        /*//CREATE user
//        userRepository.create(user);
//        userRepository.create(user2);
//        userRepository.create(user3);*/
//
//        /*//GET user with index
//        User user1 = userRepository.get(1L);
//        System.out.println(user1);*/
//
//        /*//UPDATE table with index
//        System.out.println(user);
//        userRepository.update(user);
//        User user2 = userRepository.get(1L);
//        System.out.println(user2);*/
//
//        /*//DELETE user with index
//        userRepository.delete(1L);*/
//
//        /*//GET all users
//        List<am.myOffice.shopJDBC.model.User> allUsers = userRepository.getAll();
//        for (am.myOffice.shopJDBC.model.User allUser : allUsers) {
//            System.out.println(allUser);
//        }*/
//
//
//        /*//search
//        List<User> users = userRepository.findUsersByName("y");
//        for (User user1 : users) {
//            System.out.println(user1);
//        }*/
//
//        databaseConnection.getConnection().close();

    }
}
