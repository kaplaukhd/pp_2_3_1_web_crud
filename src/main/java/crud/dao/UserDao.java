package crud.dao;

import java.util.List;

public interface UserDao<L,E> {

    void saveUser(E user);

    List<E> getAllUsers();

    void removeUser(L id);

    E getUserById(L id);

    void updateUser(E user);
}
