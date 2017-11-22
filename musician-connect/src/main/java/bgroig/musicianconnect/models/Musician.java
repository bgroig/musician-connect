package bgroig.musicianconnect.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bgroig on 7/4/2017.
 */
@Entity
public class Musician {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    private String password;

    private String instrument;

    private String description;

    private String location;


    public Musician() { }

    public Musician(String username, String email, String password,
                    String instrument, String description, String location) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.instrument = instrument;
        this.description = description;
        this.location = location;

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
