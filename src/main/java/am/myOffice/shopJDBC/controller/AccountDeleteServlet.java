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

public class AccountDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepositoryImpl(DatabaseConnection.getInstance());
        UserService userService = new UserServiceImpl(userRepository);

        try {
            String email = (String)req.getSession().getAttribute("email");
            userService.deleteAccount(email);
            req.getRequestDispatcher(Path.INDEX_PATH).forward(req,resp);
        } catch (Exception e){
            req.setAttribute("message",e.getMessage());
        }
    }
}
