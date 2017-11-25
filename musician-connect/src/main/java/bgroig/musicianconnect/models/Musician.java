package bgroig.musicianconnect.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private Profile profile;

    public Musician() { }

    public Musician(String username, String email, String password,
                    Profile profile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


}
