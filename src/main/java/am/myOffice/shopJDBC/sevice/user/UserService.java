package am.myOffice.shopJDBC.sevice.user;

import am.myOffice.shopJDBC.model.User;

public interface UserService {

    void register(User user) throws Exception;
    void login(String email, String password) throws Exception;

}
