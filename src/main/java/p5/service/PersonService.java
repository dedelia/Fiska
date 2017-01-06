package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import p5.api.interfaces.IPersonApi;
import p5.model.Internship;
import p5.model.Person;

import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */
@RestController
public class PersonService {
    //call only api (url request)

    @Autowired
    private IPersonApi personApi;

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public Set<Person> getPeople() {
        Set<Person> setOfPeople = personApi.getPersonSet();
        return setOfPeople;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    @ResponseBody
    public void addPerson(@RequestBody Person person) {
        personApi.addPerson(person);
    }

    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePerson(@RequestBody Person person) {
        // finds person by id and updates the username, if there's no id in the obj-> should not update
        personApi.updatePerson(person);

    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@PathVariable Long id) {
        personApi.deletePerson(id);
    }


    @RequestMapping(value = "/people/{id}/internships", method = RequestMethod.GET)
    @ResponseBody
    public Set<Internship> getInternhipsForPerson(@PathVariable Long id) {
        return personApi.getInternshipSetForPerson(id);
    }

    @RequestMapping(value = "/personInternshipsType", method = RequestMethod.GET)
    @ResponseBody
    public Set<Internship> getInternhipsForPersonByType(@RequestParam(value = "personId", required = true) Long personId,
                                                        @RequestParam(value = "internshipType", required = true) String internshipType) {
        return personApi.getInternhipsForPersonByType(personId,internshipType);
    }

}
