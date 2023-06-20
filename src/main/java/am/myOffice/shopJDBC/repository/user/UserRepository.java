package am.myOffice.shopJDBC.repository.user;

import am.myOffice.shopJDBC.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    void create(User user) throws Exception;

    void update(User user) throws Exception;

    User get(Long id) throws SQLException;

    List<User> getAll() throws SQLException;

    List<User> findUsersByName(String name) throws SQLException;

    void delete(Long id);

    User findUsersByEmail(String email);
}