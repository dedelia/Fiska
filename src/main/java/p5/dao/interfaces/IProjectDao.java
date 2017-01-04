package p5.dao.interfaces;

import p5.model.Project;

import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface IProjectDao {
    /**
     * @return
     */
    public Set<Project> getAllProjects();

    /**
     * @param project
     */
    public void addProject(Project project);

    /**
     * @param project
     */
    public void updateProject(Project project);

    /**
     * @param projectId
     */
    public void deleteProject(Long projectId);

    /**
     * @param projectId
     * @return
     */
    public Project findById(Long projectId);

}
