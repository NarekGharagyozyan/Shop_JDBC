package sevice.user;

import model.User;

import java.sql.SQLException;

public interface UserService {

    void register(User user) throws Exception;
    void login(String email, String password) throws Exception;

}
