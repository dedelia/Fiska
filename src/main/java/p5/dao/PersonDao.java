package p5.dao;

import p5.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
public class PersonDao implements IPersonDao {
    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getAllPeople() {
        return this.entityManager.createQuery("from Person").getResultList();
    }


}
