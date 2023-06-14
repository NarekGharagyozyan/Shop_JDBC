package repository.product.impl;

import model.Product;
import model.User;
import repository.product.ProductRepository;
import util.DatabaseConnection;

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
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getCategory());
        preparedStatement.setBoolean(4, product.isExists());


        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE products SET name = ?, price = ?, category = ?, isexists = ? WHERE id = ?"
        );

        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getCategory());
        preparedStatement.setBoolean(4, product.isExists());
        preparedStatement.setLong(5, product.getId());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public Product get(Long id) throws SQLException {
        Product product = new Product();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from products WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            setProductFields(product, resultSet);
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
    public void delete(Long id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from products WHERE id = ?");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

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
