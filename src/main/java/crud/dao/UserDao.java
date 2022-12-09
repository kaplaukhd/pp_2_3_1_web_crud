package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> getAllUsers();

    void removeUser(Long id);

    User getUserById(Long id);

    void updateUser(User user);
}
