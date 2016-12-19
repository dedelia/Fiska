package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import p5.dao.PersonDao;
import p5.model.Person;

import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
public class PersonApi {
    // transactional, only calls on dao
    @Autowired
    PersonDao personDao;

    public PersonApi(){}

    public PersonApi(PersonDao personDao) {
       this.personDao =personDao;
    }

    public List<Person> getPersonList()
    {
     return personDao.getAllPeople();
    }

    public PersonDao getPerson() {
        return personDao;
    }

    public void setPerson(PersonDao personDao) {
        this.personDao = personDao;
    }
}
