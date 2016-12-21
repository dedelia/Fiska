package p5.dao.interfaces;

import p5.model.Person;
import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */
    public interface IPersonDao {

        public Set<Person> getAllPeople();
//        public void addPerson(Person personId);
//        public void updatePerson(Person person);
//        public void deletePerson(Long personId);
//        public Person getPerson(Long personId);

    }

