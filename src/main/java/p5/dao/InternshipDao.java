package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.dao.interfaces.IInternshipDao;
import p5.model.Internship;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
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
        Internship itemFromDbs = this.getInternship(internship.getId());
        if (itemFromDbs != null) {
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
        Internship itemFromDbs = this.getInternship(internshipId);
        if (itemFromDbs != null) {
            session.delete(itemFromDbs);
        }
    }

    @Transactional
    public Internship getInternship(Long internshipId) {
        Session session = this.sessionFactory.getCurrentSession();
        if (internshipId != null) {
            Query query = session.createQuery("from p5.model.Internship i WHERE i.id = :internshipId ");
            query.setParameter("internshipId", internshipId);
            List<Internship> result = query.list();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }
}
