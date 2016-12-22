package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.dao.interfaces.ICompanyDao;
import p5.model.Company;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public class CompanyDao implements ICompanyDao {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Company> getAllCompanies() {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Company");
        Set<Company> setCompanies = new HashSet<Company>(query.list());
        return setCompanies;
    }

    @Transactional
    public void addCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(company);
    }

    @Transactional
    public void updateCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        Company itemFromDbs = this.getCompany(company.getId());
        if (itemFromDbs != null) {
            itemFromDbs.setCompanyName(company.getCompanyName());
            itemFromDbs.setInternshipSet(company.getInternshipSet());
            session.persist(itemFromDbs);
        }
    }

    @Transactional
    public void deleteCompany(Long companyId) {
        Session session = this.sessionFactory.getCurrentSession();
        Company itemFromDbs = this.getCompany(companyId);
        if (itemFromDbs != null) {
            session.delete(itemFromDbs);
        }
    }

    @Transactional
    public Company getCompany(Long companyId) {
        Session session = this.sessionFactory.getCurrentSession();
        if (companyId != null) {
            Query query = session.createQuery("from p5.model.Company c WHERE c.id = :companyId ");
            query.setParameter("companyId", companyId);
            List<Company> result = query.list();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

}
