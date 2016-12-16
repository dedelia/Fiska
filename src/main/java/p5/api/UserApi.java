package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p5.dao.UserDao;
import p5.model.User;

import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */
public class UserApi {
    // transactional, only calls on dao
    @Autowired
    UserDao userDao;

    public UserApi(){}

    public UserApi(UserDao user) {
       this.userDao =user;
    }

    public List<User> getUserList()
    {
     return userDao.getAllUsers();
    }

    public UserDao getUser() {
        return userDao;
    }

    public void setUser(UserDao user) {
        this.userDao = user;
    }
}
