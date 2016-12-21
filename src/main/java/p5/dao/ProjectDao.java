package p5.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import p5.dao.interfaces.IProjectDao;
import p5.model.Project;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
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
        Set<Project> setProjects=new HashSet<Project>(query.list());
        return setProjects;
    }
}
