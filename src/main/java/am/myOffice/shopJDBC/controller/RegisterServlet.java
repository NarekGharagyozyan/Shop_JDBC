package am.myOffice.shopJDBC.controller;

import am.myOffice.shopJDBC.model.User;
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

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRepository userRepository = new UserRepositoryImpl(DatabaseConnection.getInstance());
        UserService userService = new UserServiceImpl(userRepository);
        User user = new User();


        try {
            user.setName(req.getParameter("name"));
            user.setLastname(req.getParameter("lastname"));
            user.setBalance(Double.parseDouble(req.getParameter("balance")));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setAge(Integer.parseInt(req.getParameter("age")));

            userService.register(user);
            resp.sendRedirect("home.html");
        } catch (Exception e) {
            resp.getWriter().write("Go back and try again");
        }
    }
}
