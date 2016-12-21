package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import p5.api.interfaces.ICompanyApi;
import p5.dao.interfaces.ICompanyDao;
import p5.model.Company;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class CompanyApi implements ICompanyApi{

    @Autowired
    ICompanyDao compayDao;

    public CompanyApi() {}

    public CompanyApi(ICompanyDao compayDao) {
        this.compayDao=compayDao;
    }

    public Set<Company> getCompanySet() {
        return compayDao.getAllCompanies();
    }

    public ICompanyDao getCompanyDao() {
        return compayDao;
    }

    public void setCompanyDao(ICompanyDao companyDao) {
    this.compayDao=companyDao;
    }
}
