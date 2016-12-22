package p5.api.interfaces;

import p5.dao.interfaces.IPersonDao;
import p5.model.Person;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IPersonApi {

    public Set<Person> getPersonSet();

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Long personId);
}
