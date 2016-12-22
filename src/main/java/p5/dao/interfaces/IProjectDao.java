package p5.dao.interfaces;

import p5.model.Project;

import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface IProjectDao {

    public Set<Project> getAllProjects();

    public void addProject(Project project);

    public void updateProject(Project project);

    public void deleteProject(Long projectId);

    public Project getProject(Long projectId);

}
