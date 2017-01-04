package p5.dao.interfaces;

import p5.exceptions.DataMissingException;
import p5.model.Company;

import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface ICompanyDao {
    /**
     * @return
     */
    Set<Company> getAllCompanies();

    /**
     * @param company
     */
    void addCompany(Company company);

    /**
     * @param company
     */
    void updateCompany(Company company);

    /**
     * @param companyId
     * @throws DataMissingException
     */
    void deleteCompany(Long companyId) throws DataMissingException;

    /**
     * @param companyId
     * @return
     */
    Company findById(Long companyId);
}
