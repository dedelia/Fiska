package p5.dao.interfaces;

import p5.model.Person;

import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */
public interface IPersonDao {
    /**
     * @return
     */
    Set<Person> getAllPeople();

    /**
     * @param personId
     */
    void addPerson(Person personId);

    /**
     * @param person
     */
    void updatePerson(Person person);

    /**
     * @param personId
     */
    void deletePerson(Long personId);

    /**
     * @param personId
     * @return
     */
    Person findById(Long personId);

}

