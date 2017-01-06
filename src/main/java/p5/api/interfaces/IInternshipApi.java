package p5.api.interfaces;

import p5.model.Internship;

import java.util.Set;

/**
 * Created by dtristu on 21.12.2016.
 */
public interface IInternshipApi {

    Set<Internship> getInternshipSet();

    void addInternship(Internship internship);

    void updateInternship(Internship internship);

    void deleteInternship(Long internshipId);

    Set<Internship> getInternshipsOfType(String type);
}
