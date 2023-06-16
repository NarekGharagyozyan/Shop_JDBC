package am.myOffice.shopJDBC.repository.product.impl;

import am.myOffice.shopJDBC.model.Product;
import am.myOffice.shopJDBC.repository.product.ProductRepository;
import am.myOffice.shopJDBC.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final Connection connection;

    public ProductRepositoryImpl(DatabaseConnection databaseConnection) {
        this.connection = databaseConnection.getConnection();
        try {
            this.connection.createStatement().executeUpdate(
                    """
                            CREATE TABLE IF NOT EXISTS products (
                            id bigserial primary key,
                            name varchar(255) not null,
                            price double precision not null,
                            category varchar(255) not null,
                            isExists bool
                            )
                            """);
        } catch (SQLException e) {
            System.out.println("Connection exception");
        }

    }
    @Override
    public void create(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO products (name,price,category,isExists) VALUES (?,?,?,?)"
        );
        try{
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setBoolean(4, product.isExists());
        }catch (Exception e){
            throw new RuntimeException("Something went wrong");
        }


        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Product product, Long id) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE products SET name = ?, price = ?, category = ?, isexists = ? WHERE id = ?"
        );

        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getCategory());
        preparedStatement.setBoolean(4, product.isExists());
        preparedStatement.setLong(5, id);

        var i = preparedStatement.executeUpdate();
        if (i == 0){
            throw new Exception("Product not found");
        }
        preparedStatement.close();
    }

    @Override
    public Product get(Long id) throws Exception {
        Product product = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from products WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            product = new Product();
            setProductFields(product, resultSet);
        }

        if (product == null){
            throw new RuntimeException("product not found");
        }
        resultSet.close();
        preparedStatement.close();
        return product;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> productsList = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * from products");
        addProductToListFromResultSet(productsList, resultSet);
        return productsList;
    }

    @Override
    public List<Product> findProductsByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM products WHERE lower(name) LIKE lower(concat('%',?,'%'))"
        );
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        addProductToListFromResultSet(products, resultSet);
        return products;
    }

    @Override
    public void delete(Long id) throws Exception {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from products WHERE id = ?");
        preparedStatement.setLong(1, id);

        try {
            var i = preparedStatement.executeUpdate();
            if (i == 0)
                throw new Exception("error with deleting");
        } catch (Exception e) {
            throw new Exception(e);
        }

        preparedStatement.close();
    }

    private void setProductFields(Product product, ResultSet resultSet) throws SQLException {
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setCategory(resultSet.getString("category"));
        product.setExists(resultSet.getBoolean("isexists"));
    }

    private void addProductToListFromResultSet(List<Product> productsList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Product product = new Product();
            setProductFields(product, resultSet);
            productsList.add(product);
        }
    }


}
