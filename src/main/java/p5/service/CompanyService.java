package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public Set<Company> getCompanies()
    {
        Set<Company> setOfCompanies = companyApi.getCompanySet();
        return setOfCompanies;
    }

    public ICompanyApi getCompanyApi() {
        return companyApi;
    }

    public void setCompanyApi(ICompanyApi companyApi) {
        this.companyApi = companyApi;
    }
}
