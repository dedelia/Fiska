package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import p5.dao.interfaces.IPersonDao;
import p5.model.Person;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */
public class PersonDao implements IPersonDao {

    @Autowired
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Person> getAllPeople() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Person");
        Set<Person> setPeople=new HashSet<Person>(query.list());
        return setPeople;
    }

//    @Transactional
//    public void addPerson(Person personId) {
//        sessionFactory.persist(personId);
//    }
//
//    @Transactional
//    public void updatePerson(Person person) {
//        Person itemFromDbs = this.getPerson(person.getId());
//        if (itemFromDbs != null) {
//            itemFromDbs.setUsername(person.getUsername());
//            itemFromDbs.setInternshipList(person.getInternshipList());
//            sessionFactory.persist(itemFromDbs);
//        }
//    }
//
//    @Transactional
//    public void deletePerson(Long personId) {
//
//        Person itemFromDbs = this.getPerson(personId);
//        if (itemFromDbs != null) {
//            sessionFactory.remove(itemFromDbs);
//        }
//    }
//
//    @Transactional
//    public Person getPerson(Long personId) {
//        if (personId != null) {
//            Query query = this.sessionFactory.createQuery("from Person WHERE person_id =: personId ");
//            query.setParameter("personId", personId);
//            List<Person> result = query.getResultList();
//            if (!result.isEmpty()) {
//                return result.get(0);
//            }
//
//        }
//        return null;
//    }

}
