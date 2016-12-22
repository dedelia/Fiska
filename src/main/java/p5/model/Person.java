package p5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dtristu on 14.12.2016.
 */

@Entity
@Table(name = "person")
@JsonIgnoreProperties
public class Person {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Column(name = "person_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_internship",
            joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "internship_id", referencedColumnName = "internship_id")})
    private Set<Internship> internshipSet;

    public Person() {
        this.internshipSet = new HashSet<Internship>();
    }

    public Person(String username) {

        this.username = username;
        this.internshipSet = internshipSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Internship> getInternshipSet() {
        return internshipSet;
    }

    public void setInternshipSet(Set<Internship> internshipSet) {
        this.internshipSet = internshipSet;
    }

}

