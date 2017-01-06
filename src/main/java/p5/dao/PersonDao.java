package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import p5.dao.interfaces.IPersonDao;
import p5.exceptions.DataMissingException;
import p5.model.Internship;
import p5.model.Person;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

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
        Set<Person> setPeople = new HashSet<Person>(query.list());
        return setPeople;
    }

    @Transactional
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        Person itemFromDbs = this.findById(person.getId());
        if (itemFromDbs.getId() != null) {
            itemFromDbs.setUsername(person.getUsername());
            itemFromDbs.setInternshipSet(person.getInternshipSet());
            session.persist(itemFromDbs);
        }
    }

    @Transactional
    public void deletePerson(Long personId) {
        Session session = this.sessionFactory.getCurrentSession();
        Person itemFromDbs = this.findById(personId);
        if (itemFromDbs != null) {
            session.delete(itemFromDbs);
        }
    }

    @Transactional
    public Optional<Person> findByIdIfExists(Long personId) {
        Session session = this.sessionFactory.getCurrentSession();
        if (personId != null) {
            Query query = session.createQuery("from p5.model.Person c WHERE c.id = :personId ");
            query.setParameter("personId", personId);
            List<Person> result = query.list();
            if (!result.isEmpty()) {
                return Optional.ofNullable(result.get(0));
            }

        }
        return Optional.empty();
    }

    @Transactional
    public Person findById(Long personId) {
        Optional<Person> person = findByIdIfExists(personId);
        if (!person.isPresent())
            throw new DataMissingException("400", "Object not found");

        return person.get();
    }

    @Transactional
    public Set<Internship> getIntershipSetForPerson(Long personId) {
        Set<Internship> internshipSet = new HashSet<Internship>();
        if (personId != null) {
            Person person = findById(personId);
            internshipSet = person.getInternshipSet();

        }
        return internshipSet;
    }

    @Transactional
    public Set<Internship> getInternhipsForPersonByType(Long personId,String internshipType) {
        Session session = this.sessionFactory.getCurrentSession();
        Set<Internship> internshipSet=new HashSet<>();
        if (personId != null && internshipType.length()>0) {
            Query query = session.createQuery("from p5.model.Person p join p.internshipSet i" +
                    " where p.id=:personId and i.type =:internshipType");
            query.setParameter("personId", personId);
            query.setParameter("internshipType", internshipType);

            internshipSet = new HashSet<Internship>(query.list());
        }
        return internshipSet;
    }
}
