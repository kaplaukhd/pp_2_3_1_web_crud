package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();

    void removeUser(Long id);

    User getUserById(Long id);

    void updateUser(User user);

}
