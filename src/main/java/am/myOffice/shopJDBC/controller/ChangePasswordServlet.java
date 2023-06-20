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

public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRepository userRepository = new UserRepositoryImpl(DatabaseConnection.getInstance());
        UserService userService = new UserServiceImpl(userRepository);

        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        String repeatPassword = req.getParameter("repeatPassword");

        ProductRepository productRepository = new ProductRepositoryImpl(DatabaseConnection.getInstance());
        var allProducts = productRepository.getAll();
        var columns = productRepository.getColumns();


        try {
            userService.changePassword(email,newPassword,repeatPassword);
            req.setAttribute("email", email);
            req.setAttribute("products", allProducts);
            req.setAttribute("columns", columns);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        }catch (Exception e) {
            req.setAttribute("message",e.getMessage());
            req.setAttribute("email", email);
            req.getRequestDispatcher("changePassword.jsp").forward(req,resp);
        }

    }



}
