package p5.dao.interfaces;

import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface IInternshipDao {

    public Set<Internship> getAllInternships();

    public void addInternship(Internship internship);

    public void updateInternship(Internship company);

    public void deleteInternship(Long companyId);

    public Internship getInternship(Long companyId);
}
