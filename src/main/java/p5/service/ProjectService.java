package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import p5.api.interfaces.IProjectApi;
import p5.model.Project;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
@RestController
public class ProjectService {
    //call only api (url request)

    @Autowired
    private IProjectApi projectApi;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public Set<Project> getProjects()
    {
        Set<Project> setOfProjects = projectApi.getProjectSet();
        return setOfProjects;
    }

    public IProjectApi getProjectApi() {
        return projectApi;
    }

    public void setProjectApi(IProjectApi projectApi) {
        this.projectApi = projectApi;
    }
}
