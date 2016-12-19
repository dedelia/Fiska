package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name = "internshipFk", referencedColumnName = "internship")
    @ManyToMany
    private List<Internship> internshipList;

    public Project(){}

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }
}
