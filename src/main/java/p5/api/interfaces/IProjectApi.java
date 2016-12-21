package p5.api.interfaces;

import p5.dao.interfaces.IProjectDao;
import p5.model.Project;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IProjectApi {

    public Set<Project> getProjectSet();
    public IProjectDao getProjectDao();
    public void setProjectDao(IProjectDao projectDao);

}
