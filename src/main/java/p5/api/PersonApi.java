package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import p5.api.interfaces.IPersonApi;
import p5.dao.interfaces.IPersonDao;
import p5.model.Person;

import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */
public class PersonApi implements IPersonApi {

    // transactional, only calls on dao
    @Autowired
    IPersonDao personDao;

    public PersonApi() {
    }

    public PersonApi(IPersonDao personDao) {
        this.personDao = personDao;
    }

    public Set<Person> getPersonSet() {
        return personDao.getAllPeople();
    }

    public void addPerson(Person person) {
        this.personDao.addPerson(person);

    }

    public void deletePerson(Long personId) {
        this.personDao.deletePerson(personId);

    }

    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);
    }

}
