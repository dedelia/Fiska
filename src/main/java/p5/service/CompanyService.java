package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import p5.api.interfaces.ICompanyApi;
import p5.model.Company;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
@RestController
public class CompanyService {

    @Autowired
    private ICompanyApi companyApi;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public Set<Company> getCompanies() {
        Set<Company> setOfCompanies = companyApi.getCompanySet();
        return setOfCompanies;
    }

    @RequestMapping(value = "/companies/{company_name}", method = RequestMethod.POST)
    @ResponseBody
    public void addCompany(@PathVariable("company_name") String company_name) {
        //used path variables -> TODO replace with webParams and clean up urls

        Company company = new Company();
        company.setCompanyName(company_name);
        companyApi.addCompany(company);
    }

    @RequestMapping(value = "/companies/{id}/{company_name}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCompany(@PathVariable("id") Long id,
                              @PathVariable("company_name") String company_name) {
        // finds company by id and updates the username
        Company company = new Company();
        company.setId(id);
        company.setCompanyName(company_name);
        companyApi.updateCompany(company);

    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCompany(@PathVariable("id") Long id) {
        companyApi.deleteCompany(id);
    }
}
