package p5.api.interfaces;

import p5.dao.interfaces.IInternshipDao;
import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IInternshipApi {

    public Set<Internship> getInternshipSet();
    public IInternshipDao getInternshipDao();
    public void setInternshipDao(IInternshipDao internshipDao);

}
