package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Column(name="company_id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "internship", joinColumns = @JoinColumn(name = "company_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "company_fk", nullable = false))
    private Set<Internship> internshipSet;

    public Company() {}

    public Company(String companyName,Set<Internship> internshipSet) {

        this.companyName = companyName;
        this.internshipSet=internshipSet;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Internship> getInternshipSet() {
        return internshipSet;
    }

    public void setInternshipSet(Set<Internship> internshipSet) {
        this.internshipSet = internshipSet;
    }

}
