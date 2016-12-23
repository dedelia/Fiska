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

    @RequestMapping(value = "/internships", method = RequestMethod.POST)
    @ResponseBody
    public void addInternship(@RequestBody Internship internship) {
        internshipApi.addInternship(internship);
    }

    @RequestMapping(value = "/internships", method = RequestMethod.PUT)
    @ResponseBody
    public void updateInternship(@RequestBody Internship internship) {
        // finds internship by id and updates the username, if there's no id in the obj-> should not update
        internshipApi.updateInternship(internship);

    }

    @RequestMapping(value = "/internships/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteInternship(@PathVariable("id") Long id) {
        internshipApi.deleteInternship(id);
    }

}
