package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dtristu on 14.12.2016.
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;

    @Column(name = "username")
    private String username;

    @JoinColumn(name = "internshipFk", referencedColumnName = "internship")
    @ManyToMany
    private List<Internship> internshipList;

    public Person() {}

    public Person(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }
}

