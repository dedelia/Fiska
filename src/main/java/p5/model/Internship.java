package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dtristu on 16.12.2016.
 */
@Entity
@Table(name = "internship")
public class Internship {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;

    @Column(name = "type")
    private String type;

    @JoinColumn(name = "companyFk", referencedColumnName = "company")
    @ManyToOne(optional = false)
    private Company companyFk;

    @JoinColumn(name = "personFk", referencedColumnName = "person")
    @ManyToMany
    private List<Person> personList;

    public Internship() {}

    public Internship(String type) {
        this.type = type;
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

    public Company getCompanyFk() {
        return companyFk;
    }

    public void setCompanyFk(Company companyFk) {
        this.companyFk = companyFk;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
