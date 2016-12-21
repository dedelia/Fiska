package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.model.Internship;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class InternshipDao implements IInternshipDao {
    @Resource
    private SessionFactory sessionFactory;

    public Set<Internship> getAllInternships() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Person");
        Set<Internship> setInternships=new HashSet<Internship>(query.list());
        return setInternships;
    }
}
