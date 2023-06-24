package am.myOffice.shopJDBC.controller;

import am.myOffice.shopJDBC.repository.user.UserRepository;
import am.myOffice.shopJDBC.repository.user.impl.UserRepositoryImpl;
import am.myOffice.shopJDBC.sevice.user.UserService;
import am.myOffice.shopJDBC.sevice.user.impl.UserServiceImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;
import am.myOffice.shopJDBC.util.constants.Path;
import am.myOffice.shopJDBC.util.CookieUtil;
import am.myOffice.shopJDBC.util.encoder.AESManager;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends HelloServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encodedString = CookieUtil.getCookieValueByName(req.getCookies(), "remember");

        UserService userService = new UserServiceImpl(new UserRepositoryImpl(DatabaseConnection.getInstance()));

        try {
            if (encodedString != null){
                String decrypt = AESManager.decrypt(encodedString);
                String email = decrypt.split(":")[0];
                String password = decrypt.split(":")[1];

                userService.login(email,password);

                Cookie cookie = new Cookie("remember", AESManager.encrypt(email + ":" + password));
                cookie.setMaxAge(360000);
                resp.addCookie(cookie);

                req.getSession().setAttribute("email", email);
                req.getRequestDispatcher(Path.HOME_PATH).forward(req,resp);
            }else {
                resp.sendRedirect(Path.INDEX_PATH);
            }
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher(Path.INDEX_PATH).forward(req,resp);
        }
    }
}
