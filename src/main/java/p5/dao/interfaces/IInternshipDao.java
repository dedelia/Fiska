package p5.dao.interfaces;

import p5.model.Internship;

import java.util.Optional;
import java.util.Set;

/**
 * Created by dtristu on 19.12.2016.
 */
public interface IInternshipDao {
    /**
     * @return
     */
    Set<Internship> getAllInternships();

    /**
     * @param internship
     */
    void addInternship(Internship internship);

    /**
     * @param company
     */
    void updateInternship(Internship company);

    /**
     * @param internshipId
     */
    void deleteInternship(Long internshipId);

    /**
     * @param internshipId
     * @return
     */
    Internship findById(Long internshipId);
}
