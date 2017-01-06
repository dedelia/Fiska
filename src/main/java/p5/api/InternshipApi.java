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

    public InternshipApi() {
    }

    public InternshipApi(IInternshipDao internshipDao) {
        this.internshipDao = internshipDao;
    }

    public Set<Internship> getInternshipSet() {
        return internshipDao.getAllInternships();
    }

    public void addInternship(Internship internship) {
        this.internshipDao.addInternship(internship);
    }

    public void updateInternship(Internship internship) {
        this.internshipDao.updateInternship(internship);
    }

    public void deleteInternship(Long internshipId) {
        this.internshipDao.deleteInternship(internshipId);
    }

    public Set<Internship> getInternshipsOfType(String type) {
        return this.internshipDao.getIntershipsOfType(type);
    }


}
