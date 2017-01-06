package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.dao.interfaces.IInternshipDao;
import p5.exceptions.DataMissingException;
import p5.model.Internship;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class InternshipDao implements IInternshipDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Internship> getAllInternships() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Internship");
        Set<Internship> setInternships = new HashSet<Internship>(query.list());
        return setInternships;
    }


    @Transactional
    public void addInternship(Internship internship) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(internship);
    }

    @Transactional
    public void updateInternship(Internship internship) {
        Session session = this.sessionFactory.getCurrentSession();
        Internship itemFromDbs = this.findById(internship.getId());
        if (itemFromDbs.getId() != null) {
            itemFromDbs.setType(internship.getType());
            itemFromDbs.setPersonSet(internship.getPersonSet());
            itemFromDbs.setProjectSet(internship.getProjectSet());
            itemFromDbs.setCompany(internship.getCompany());
            session.persist(itemFromDbs);
        }
    }

    @Transactional
    public void deleteInternship(Long internshipId) {
        Session session = this.sessionFactory.getCurrentSession();
        Internship itemFromDbs = this.findById(internshipId);
        if (itemFromDbs != null) {
            session.delete(itemFromDbs);
        }
    }

    @Transactional
    public Optional<Internship> findByIdIfExists(Long internshipId) {
        Session session = this.sessionFactory.getCurrentSession();
        if (internshipId != null) {
            Query query = session.createQuery("from p5.model.Internship i WHERE i.id = :internshipId ");
            query.setParameter("internshipId", internshipId);
            List<Internship> result = query.list();
            if (!result.isEmpty()) {
                return Optional.ofNullable(result.get(0));
            }

        }
        return Optional.empty();
    }

    @Transactional
    public Internship findById(Long internshipId) {
        Optional<Internship> internship = findByIdIfExists(internshipId);
        if (!internship.isPresent())
            throw new DataMissingException("400", "Object not found");

        return internship.get();
    }

    @Transactional
    public Set<Internship> getIntershipsOfType(String type){
        Session session = this.sessionFactory.getCurrentSession();

            Query query = session.createQuery("from p5.model.Internship i WHERE i.type like :type");
            query.setParameter("type", type);
            Set<Internship> setInternships = new HashSet<Internship>(query.list());

        return setInternships;
    }
}
