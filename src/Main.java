import model.Product;
import model.User;
import repository.product.ProductRepository;
import repository.product.impl.ProductRepositoryImpl;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryImpl;
import sevice.user.UserService;
import sevice.user.impl.UserServiceImpl;
import util.DatabaseConnection;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

        UserRepository userRepository = new UserRepositoryImpl(databaseConnection);
        ProductRepository productRepository = new ProductRepositoryImpl(databaseConnection);

        User user = new User(1L, "Gogo", "Khachatryan", "username1@gmail.com", "password1", 27);
        User user2 = new User(2L, "Nini", "Harutyunyan", "username2@gmail.com", "password2", 29);
        User user3 = new User(3L, "Hoso", "Parunakyan", "username3@gmail.com", "password3", 23);

        Product product = new Product(1L,"Bread","Grocery", true);
        Product product2 = new Product(2L,"Iphone","Electronic", false);


        //----------PRODUCTS-------------
        /*//CREATE product
        productRepository.create(product2);*/


        /*//UPDATE product
        productRepository.get(1L);
        productRepository.update(product);
        productRepository.get(1L);*/


        /*//GET product
        Product product1 = productRepository.get(1L);
        System.out.println(product1);*/


        /*//GET all products
        for (Product product1 : productRepository.getAll()) {
            System.out.println(product1);
        }*/


        /*//find product by name
        List<Product> iphone = productRepository.findProductsByName("Iphone");
        for (Product product1 : iphone) {
            System.out.println(product1);
        }*/

        /*//DELETE product by index
        productRepository.delete(1L);*/



        //-------USERS----------
        UserService userService = new UserServiceImpl(userRepository);

        //userService.register(user3);
        //userService.login("username1@gmail.com", "password1");


        //CREATE user
        /*userRepository.create(user);
        userRepository.create(user2);
        userRepository.create(user3);*/

        /*//GET user with index
        User user1 = userRepository.get(1L);
        System.out.println(user1);*/

        /*//UPDATE table with index
        System.out.println(user);
        userRepository.update(user);
        User user2 = userRepository.get(1L);
        System.out.println(user2);*/

        /*//DELETE user with index
        userRepository.delete(1L);*/

        /*//GET all users
        List<model.User> allUsers = userRepository.getAll();
        for (model.User allUser : allUsers) {
            System.out.println(allUser);
        }*/


        /*//search
        List<User> users = userRepository.findUsersByName("y");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        databaseConnection.getConnection().close();
    }
}
