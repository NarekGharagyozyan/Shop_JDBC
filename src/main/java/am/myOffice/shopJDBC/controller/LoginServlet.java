package am.myOffice.shopJDBC.controller;

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
import java.io.PrintWriter;

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
        var email = req.getParameter("email");
        var password = req.getParameter("password");

        try {
            userService.login(email,password);
            resp.sendRedirect("home.html");
        } catch (Exception e) {
            resp.getWriter().write("<!doctype html>\n" +
                                   "<html lang=\"en\">\n" +
                                   "<head>\n" +
                                   "    <meta charset=\"UTF-8\">\n" +
                                   "    <meta name=\"viewport\"\n" +
                                   "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                                   "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                   "    <title>Document</title>\n" +
                                   "</head>\n" +
                                   "<body>\n" +
                                   "<h1>Invalid login or password</h1>\n" +
                                   "\n" +
                                   "    <h1>Login</h1>\n" +
                                   "    <form method=\"post\" action=\"/login\">\n" +
                                   "        email: <input type=\"text\" name=\"email\"></br>\n" +
                                   "        password: <input type=\"password\" name=\"password\"></br>\n" +
                                   "        <input type=\"submit\" value=\"login\">\n" +
                                   "    </form>\n" +
                                   "</body>\n" +
                                   "</html>");
        }



    }
}
