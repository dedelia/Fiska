package p5.dao;

import p5.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
public class UserDao implements IUserDao {
    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        return this.entityManager.createQuery("from User").getResultList();
    }


}
