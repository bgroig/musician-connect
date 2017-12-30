package bgroig.musicianconnect.models;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bgroig on 7/4/2017.
 */
@Component
@Entity
public class Musician {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String instruments;

    private String musicStyles;

    private String location;

    private String ability;

    public Musician() { }

    public Musician(String username, String password, String instruments, String musicStyles,
                    String location, String ability) {

        this.username = username;
        this.password = password;
        this.instruments = instruments;
        this.musicStyles = musicStyles;
        this.location = location;
        this.ability = ability;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstruments() {
        return instruments;
    }

    public int getId() {
        return id;
    }

    public void setInstruments(String instruments) {
        this.instruments = instruments;
    }

    public String getMusicStyles() {
        return musicStyles;
    }

    public void setMusicStyles(String musicStyles) {
        this.musicStyles = musicStyles;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(bgroig.musicianconnect.models.Email email) {
        System.out.println("Received <" + email + ">");
    }

}


