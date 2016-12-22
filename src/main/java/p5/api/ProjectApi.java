package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import p5.api.interfaces.IProjectApi;
import p5.dao.interfaces.IProjectDao;
import p5.model.Project;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class ProjectApi implements IProjectApi {

    @Autowired
    IProjectDao projectDao;

    public ProjectApi() {
    }

    public ProjectApi(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Set<Project> getProjectSet() {
        return projectDao.getAllProjects();
    }

    public void addProject(Project project) {
        this.projectDao.addProject(project);
    }

    public void updateProject(Project project) {
        this.projectDao.updateProject(project);

    }

    public void deleteProject(Long projectId) {
        this.projectDao.deleteProject(projectId);
    }

}
