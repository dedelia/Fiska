package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import p5.api.interfaces.IPersonApi;
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

    @RequestMapping(value = "/people/{username}", method = RequestMethod.POST)
    @ResponseBody
    public void addPerson(@PathVariable("username") String username) {
        //used path variables -> TODO replace with webParams and clean up urls

        Person person = new Person();
        person.setUsername(username);
        personApi.addPerson(person);
    }

    @RequestMapping(value = "/people/{id}/{username}", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePerson(@PathVariable("id") Long id,
                             @PathVariable("username") String username) {
        // finds person by id and updates the username
        Person person = new Person();
        person.setId(id);
        person.setUsername(username);
        personApi.updatePerson(person);

    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@PathVariable("id") Long id) {
        personApi.deletePerson(id);
    }


}
