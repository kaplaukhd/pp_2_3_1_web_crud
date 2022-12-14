package crud.service;

import java.util.List;

public interface UserService<L,E> {

    void saveUser(E user);

    List<E> getAllUsers();

    void removeUser(L id);

    E getUserById(L id);

    void updateUser(E user);

}
