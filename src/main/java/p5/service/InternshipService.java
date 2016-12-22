package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Set<Internship> getInternships() {
        Set<Internship> setOfPeople = internshipApi.getInternshipSet();
        return setOfPeople;
    }

    @RequestMapping(value = "/internships/{type}", method = RequestMethod.POST)
    @ResponseBody
    public void addInternship(@PathVariable("type") String type) {
        //used path variables -> TODO replace with webParams and clean up urls

        Internship internship = new Internship();
        internship.setType(type);
        internshipApi.addInternship(internship);
    }

    @RequestMapping(value = "/internships/{id}/{type}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateInternship(@PathVariable("id") Long id,
                                 @PathVariable("type") String type) {
        // finds internship by id and updates the username
        Internship internship = new Internship();
        internship.setId(id);
        internship.setType(type);
        internshipApi.updateInternship(internship);

    }

    @RequestMapping(value = "/internships/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteInternship(@PathVariable("id") Long id) {
        internshipApi.deleteInternship(id);
    }

}
