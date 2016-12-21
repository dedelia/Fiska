package p5.dao.interfaces;

import p5.model.Company;

import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface ICompanyDao {

    public Set<Company> getAllCompanies();/*
        public void addCompany(Company company);
        public void deleteCompany(Long companyId , Long companyId);
        public Person getCompany(Long companyId,Long companyId);*/
}
