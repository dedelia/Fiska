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

    @RequestMapping(value = "/projects/{project_name}", method = RequestMethod.POST)
    @ResponseBody
    public void addProject(@PathVariable("project_name") String project_name) {
        //used path variables -> TODO replace with webParams and clean up urls

        Project project = new Project();
        project.setProjectName(project_name);
        projectApi.addProject(project);
    }

    @RequestMapping(value = "/projects/{id}/{project_name}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProject(@PathVariable("id") Long id,
                              @PathVariable("project_name") String project_name) {
        // finds project by id and updates the username
        Project project = new Project();
        project.setId(id);
        project.setProjectName(project_name);
        projectApi.updateProject(project);

    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProject(@PathVariable("id") Long id) {
        projectApi.deleteProject(id);
    }
}
