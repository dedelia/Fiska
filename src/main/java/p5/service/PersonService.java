package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import p5.api.PersonApi;
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
    public Set<Person> getPeople()
    {
        Set<Person> setOfPeople = personApi.getPersonSet();
        return setOfPeople;
    }

    public IPersonApi getPersonApi() {
        return personApi;
    }

    public void setPersonApi(IPersonApi personApi) {
        this.personApi = personApi;
    }
}
