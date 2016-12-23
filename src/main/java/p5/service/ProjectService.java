package p5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Set<Project> getProjects() {
        Set<Project> setOfProjects = projectApi.getProjectSet();
        return setOfProjects;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    @ResponseBody
    public void addProject(@RequestBody Project project) {
        projectApi.addProject(project);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProject(@RequestBody Project project) {
        // finds project by id and updates the username, if there's no id in the obj-> should not update
        projectApi.updateProject(project);

    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProject(@PathVariable("id") Long id) {
        projectApi.deleteProject(id);
    }
}
