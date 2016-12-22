package p5.api.interfaces;

import p5.dao.interfaces.IInternshipDao;
import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IInternshipApi {

    public Set<Internship> getInternshipSet();

    public void addInternship(Internship internship);

    public void updateInternship(Internship internship);

    public void deleteInternship(Long internshipId);

}
