package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import p5.model.Project;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class ProjectDao implements IProjectDao {

    @Resource
    private SessionFactory sessionFactory;

    public Set<Project> getAllProjects() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from p5.model.Person");
        Set<Project> setProjects=new HashSet<Project>(query.list());
        return setProjects;
    }
}
