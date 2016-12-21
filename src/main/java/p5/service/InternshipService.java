package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import p5.api.interfaces.IInternshipApi;
import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
@RestController
public class InternshipService {

    @Autowired
    private IInternshipApi internshipApi;

    @RequestMapping(value = "/internships", method = RequestMethod.GET)
    public Set<Internship> getInternships()
    {
        Set<Internship> setOfPeople = internshipApi.getInternshipSet();
        return setOfPeople;
    }

    public IInternshipApi getInternshipApi() {
        return internshipApi;
    }

    public void setInternshipApi(IInternshipApi internshipApi) {
        this.internshipApi = internshipApi;
    }
}
