package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao<Long, User> {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select s from User s", User.class).getResultList();
    }

    public void removeUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class , id);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
