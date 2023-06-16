package am.myOffice.shopJDBC.sevice.user.impl;

import am.myOffice.shopJDBC.model.User;
import am.myOffice.shopJDBC.repository.user.UserRepository;
import am.myOffice.shopJDBC.sevice.user.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void register(User user) throws Exception {
        try {
            validationForRegistration(user);
            userRepository.create(user);
        } catch (Exception e) {
            throw new Exception("something is wrong");
        }
    }

    @Override
    public void login(String email, String password) throws Exception {
        validationForLogin(email, password);
        User loginedUser = userRepository.findUsersByEmailAndPassword(email, password);
        if (loginedUser == null){
            throw new RuntimeException("Wrong username or password");
        }
    }

    private void validationForRegistration(User user) throws Exception {
        if (user.getEmail() == null ||
            user.getEmail().length() == 0 ||
            !user.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                                     + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            throw new Exception("something with email is wrong");
        if (user.getPassword() == null ||
            user.getPassword().length() < 8
            )
            throw new Exception("password validation is wrong");
    }

    private void validationForLogin(String email, String password) throws Exception{
        if (email == null || password == null)
            throw new Exception("email or password is null");
    }
}
