package p5.api;

import org.springframework.beans.factory.annotation.Autowired;
import p5.api.interfaces.IInternshipApi;
import p5.dao.interfaces.IInternshipDao;
import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public class InternshipApi implements IInternshipApi {

    @Autowired
    IInternshipDao internshipDao;

    public InternshipApi() {}

    public InternshipApi(IInternshipDao internshipDao) {
        this.internshipDao=internshipDao;
    }

    public Set<Internship> getInternshipSet() {
        return internshipDao.getAllInternships();
    }

    public IInternshipDao getInternshipDao() {
        return internshipDao;
    }

    public void setInternshipDao(IInternshipDao internshipDao) {
        this.internshipDao=internshipDao;
    }
}
