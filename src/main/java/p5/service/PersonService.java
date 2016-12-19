package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import p5.api.PersonApi;
import p5.model.Person;

import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
@RestController
public class PersonService {
    //call only api (url request)

    @Autowired
    private PersonApi personApi;

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> getUsers()
    {
        List<Person> listOfPeople = personApi.getPersonList();
        return listOfPeople;
    }

    public PersonApi getPersonApi() {
        return personApi;
    }

    public void setPersonApi(PersonApi personApi) {
        this.personApi = personApi;
    }
}
