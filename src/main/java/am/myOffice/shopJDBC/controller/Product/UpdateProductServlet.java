package am.myOffice.shopJDBC.controller.Product;

import am.myOffice.shopJDBC.model.Product;
import am.myOffice.shopJDBC.repository.product.ProductRepository;
import am.myOffice.shopJDBC.repository.product.impl.ProductRepositoryImpl;
import am.myOffice.shopJDBC.util.DatabaseConnection;
import am.myOffice.shopJDBC.util.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProductRepository productRepository = new ProductRepositoryImpl(DatabaseConnection.getInstance());
        Product product = new Product();

        try {
            product.setName(req.getParameter("name"));
            product.setPrice(Double.parseDouble(req.getParameter("price")));
            product.setCategory(req.getParameter("category"));
            product.setExists(Boolean.parseBoolean(req.getParameter("isexists")));
            var id = Long.parseLong(req.getParameter("id"));

            productRepository.update(product, id);
            List<Product> allProducts = productRepository.getAll();
            List<String> columns = productRepository.getColumns();
            req.setAttribute("products",allProducts);
            req.setAttribute("columns",columns);
            req.getRequestDispatcher(Path.PRODUCT_PATH).forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("message",e.getMessage());
            req.getRequestDispatcher(Path.UPDATE_PRODUCT_PATH).forward(req,resp);
        }
    }
}
