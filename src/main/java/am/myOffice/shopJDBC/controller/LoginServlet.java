package am.myOffice.shopJDBC.controller;

import am.myOffice.shopJDBC.repository.product.ProductRepository;
import am.myOffice.shopJDBC.repository.product.impl.ProductRepositoryImpl;
import am.myOffice.shopJDBC.repository.user.UserRepository;
import am.myOffice.shopJDBC.repository.user.impl.UserRepositoryImpl;
import am.myOffice.shopJDBC.sevice.user.UserService;
import am.myOffice.shopJDBC.sevice.user.impl.UserServiceImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*//parametrov tvyali yndunum
        //http://localhost:8080/login?username=aaa&password=bbb
        var username = req.getParameter("username");
        var password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);*/


        UserRepository userRepository = new UserRepositoryImpl(DatabaseConnection.getInstance());
        UserService userService = new UserServiceImpl(userRepository);

        ProductRepository productRepository = new ProductRepositoryImpl(DatabaseConnection.getInstance());
        var allProducts = productRepository.getAll();
        var columns = productRepository.getColumns();
        String email = req.getParameter("email");
        var password = req.getParameter("password");


        try {
            userService.login(email,password);
            req.setAttribute("email", email);
            req.setAttribute("products", allProducts);
            req.setAttribute("columns", columns);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
