package p5.api.interfaces;

import p5.dao.interfaces.ICompanyDao;
import p5.model.Company;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface ICompanyApi {

    public Set<Company> getCompanySet();

    public void addCompany(Company company);

    public void updateCompany(Company company);

    public void deleteCompany(Long companyId);

}
