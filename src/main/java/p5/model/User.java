package p5.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by dtristu on 14.12.2016.
 */

@Entity
@Table(name = "person")
public class User {

    @Id
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    private Long id;

    @Column(name = "username")
    private String username;

    public User () {}

    public User(String username) {
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
}

