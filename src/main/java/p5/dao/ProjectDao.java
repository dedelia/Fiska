package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import p5.dao.interfaces.IProjectDao;
import p5.exceptions.DataMissingException;
import p5.model.Project;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class ProjectDao implements IProjectDao {

    @Autowired
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Project> getAllProjects() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Project");
        Set<Project> setProjects = new HashSet<Project>(query.list());
        return setProjects;
    }

    @Transactional
    public void addProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(project);
    }

    @Transactional
    public void updateProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        Project itemFromDbs = this.findById(project.getId());
        if(itemFromDbs.getId()!=null) {
            itemFromDbs.setProjectName(project.getProjectName());
            itemFromDbs.setInternshipSet(project.getInternshipSet());
            session.persist(itemFromDbs);
        }

    }

    @Transactional
    public void deleteProject(Long projectId) {
        Session session = this.sessionFactory.getCurrentSession();
        Project itemFromDbs = this.findById(projectId);
        if (itemFromDbs != null) {
            session.delete(itemFromDbs);
        }
    }

    @Transactional
    public Optional<Project> findByIdIfExists(Long projectId) {
        Session session = this.sessionFactory.getCurrentSession();
        if (projectId != null) {
            Query query = session.createQuery("from p5.model.Project c WHERE c.id = :projectId ");
            query.setParameter("projectId", projectId);
            List<Project> result = query.list();
            if (!result.isEmpty()) {
                return Optional.ofNullable(result.get(0));
            }

        }
        return Optional.empty();
    }

    @Transactional
    public Project findById(Long projectId) {
        Optional<Project> project = findByIdIfExists(projectId);
        if (!project.isPresent())
            throw new DataMissingException("400", "Object not found");

        return project.get();
    }
}
