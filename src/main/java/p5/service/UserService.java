package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import p5.api.UserApi;
import p5.model.User;

import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
@RestController
public class UserService {
    //call only api (url request)

    @Autowired
    private UserApi userApi;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> listOfUsers=userApi.getUserList();
        return listOfUsers;
    }

    public UserApi getUserApi() {
        return userApi;
    }

    public void setUserApi(UserApi userApi) {
        this.userApi = userApi;
    }
}
