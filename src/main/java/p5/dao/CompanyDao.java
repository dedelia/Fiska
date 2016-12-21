package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.model.Company;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public class CompanyDao implements ICompayDao {
    @Resource
    private SessionFactory sessionFactory;

    public Set<Company> getAllCompanies() {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Person");
        Set<Company> setCompanies=new HashSet<Company>(query.list());
        return setCompanies;
    }
}
