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
            resp.getWriter().write("<!doctype html>\n" +
                                   "<html lang=\"en\">\n" +
                                   "<head>\n" +
                                   "    <meta charset=\"UTF-8\">\n" +
                                   "    <meta name=\"viewport\"\n" +
                                   "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                                   "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                   "    <title>Document</title>\n" +
                                   "    <style>\n" +
                                   "        input {\n" +
                                   "            padding: 10px ;\n" +
                                   "            margin-bottom: 10px;\n" +
                                   "        }\n" +
                                   "\n" +
                                   "        .button {\n" +
                                   "            padding: 10px 30px;\n" +
                                   "        }\n" +
                                   "\n" +
                                   "    </style>\n" +
                                   "</head>\n" +
                                   "<body>\n" +
                                   "\n" +
                                   "        <div class=\"lr\">\n" +
                                   "            <h1>Please Register again</h1>\n" +
                                   "            <form method=\"post\" action=\"/register\">\n" +
                                   "                <input type=\"text\" placeholder=\"name\" name=\"name\">\n" +
                                   "                <input type=\"text\" placeholder=\"lastname\" name=\"lastname\"></br>\n" +
                                   "                <input type=\"text\" placeholder=\"balance\" name=\"balance\">\n" +
                                   "                <input type=\"email\" placeholder=\"email\" name=\"email\"></br>\n" +
                                   "                <input type=\"password\" placeholder=\"password\" name=\"password\">\n" +
                                   "                <input type=\"text\" placeholder=\"age\" name=\"age\"></br>\n" +
                                   "                <input type=\"submit\" value=\"register\">\n" +
                                   "            </form>\n" +
                                   "        </div>\n" +
                                   "    </div>\n" +
                                   "\n" +
                                   "</body>\n" +
                                   "</html>");
        }
    }
}
