package am.myOffice.shopJDBC.controller;

import am.myOffice.shopJDBC.repository.user.UserRepository;
import am.myOffice.shopJDBC.repository.user.impl.UserRepositoryImpl;
import am.myOffice.shopJDBC.sevice.user.UserService;
import am.myOffice.shopJDBC.sevice.user.impl.UserServiceImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;
import am.myOffice.shopJDBC.util.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        UserRepository userRepository = new UserRepositoryImpl(DatabaseConnection.getInstance());
        UserService userService = new UserServiceImpl(userRepository);
        var email = req.getParameter("email");
        var password = req.getParameter("password");
        try {
            userService.login(email,password);
            req.getSession().setAttribute("email", email);
            req.getRequestDispatcher(Path.HOME_PATH).forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher(Path.INDEX_PATH).forward(req,resp);
        }
    }
}
