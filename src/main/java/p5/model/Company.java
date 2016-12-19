package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @JoinColumn(name = "internshipFk", referencedColumnName = "internship")
    @OneToMany
    private List<Internship> internshipList;

    public Company() {}

    public Company(String companyName) {
        this.companyName = companyName;
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

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }
}
