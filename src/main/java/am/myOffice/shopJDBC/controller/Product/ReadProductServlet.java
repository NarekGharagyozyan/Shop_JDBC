package am.myOffice.shopJDBC.controller.Product;

import am.myOffice.shopJDBC.repository.product.ProductRepository;
import am.myOffice.shopJDBC.repository.product.impl.ProductRepositoryImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;
import am.myOffice.shopJDBC.util.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReadProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProductRepository productRepository = new ProductRepositoryImpl(DatabaseConnection.getInstance());
        try {
            var product = productRepository.get(Long.parseLong(req.getParameter("id")));
            req.setAttribute("product",product.toString());
            req.getRequestDispatcher(Path.READ_PRODUCT_PATH).forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("message",e.getMessage());
            req.getRequestDispatcher(Path.READ_PRODUCT_PATH).forward(req,resp);
        }
    }
}
