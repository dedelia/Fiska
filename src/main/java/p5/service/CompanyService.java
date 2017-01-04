package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import p5.api.interfaces.ICompanyApi;
import p5.exceptions.DataMissingException;
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

    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    @ResponseBody
    public void addCompany(@RequestBody Company company) {
        companyApi.addCompany(company);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCompany(@RequestBody Company company) {
        // finds company by id and updates the username, if there's no id in the obj-> should not update
        companyApi.updateCompany(company);

    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCompany(@PathVariable("id") Long id) throws DataMissingException {
            companyApi.deleteCompany(id);
    }

}
