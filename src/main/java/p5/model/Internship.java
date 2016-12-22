package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "internship")
public class Internship {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Column(name = "internship_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_internship",
            joinColumns = {@JoinColumn(name = "internship_id", referencedColumnName = "internship_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "person_id")})
    private Set<Person> personSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "internship_project",
            joinColumns = {@JoinColumn(name = "internship_id", referencedColumnName = "internship_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "project_id")})
    private Set<Project> projectSet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    public Internship() {
    }

    public Internship(String type, Set<Person> personSet, Set<Project> projectSet, Company company) {
        this.type = type;
        this.personSet = personSet;
        this.projectSet = projectSet;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
