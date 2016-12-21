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

    public ProjectApi() {}

    public ProjectApi(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public IProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(IProjectDao projectDao) {

        this.projectDao = projectDao;
    }

    public Set<Project> getProjectSet() {
        return projectDao.getAllProjects();
    }

}
