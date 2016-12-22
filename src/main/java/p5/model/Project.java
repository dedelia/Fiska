package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "internship_project",
            joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "internship_id", referencedColumnName = "internship_id")})
    private Set<Internship> internshipSet;

    public Project() {
    }

    public Project(String projectName, Set<Internship> internshipSet) {

        this.projectName = projectName;
        this.internshipSet = internshipSet;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Internship> getInternshipSet() {
        return internshipSet;
    }

    public void setInternshipSet(Set<Internship> internshipSet) {
        this.internshipSet = internshipSet;
    }
}
