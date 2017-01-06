package p5.api.interfaces;

import p5.dao.interfaces.IPersonDao;
import p5.model.Internship;
import p5.model.Person;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IPersonApi {

    Set<Person> getPersonSet();

    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Long personId);

    Set<Internship> getInternshipSetForPerson(Long personId);

     Set<Internship> getInternhipsForPersonByType(Long personId,String internshipType);
}
