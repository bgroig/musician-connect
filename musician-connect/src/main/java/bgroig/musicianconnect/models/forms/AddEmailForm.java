package bgroig.musicianconnect.models.forms;

import bgroig.musicianconnect.models.Email;
import bgroig.musicianconnect.models.Musician;

import javax.validation.constraints.NotNull;

/**
 * Created by bgroig on 12/28/2017.
 */
public class AddEmailForm {

    private Musician musician;

    private Iterable<Email> emails;

    @NotNull
    private int musicianId;

    @NotNull
    private int emailId;

    public AddEmailForm(){}

    public AddEmailForm(Musician musician, Iterable<Email> emails){
        this.musician = musician;
        this.emails = emails;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    public Iterable<Email> getEmails() {
        return emails;
    }

    public void setEmails(Iterable<Email> emails) {
        this.emails = emails;
    }

    public int getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(int musicianId) {
        this.musicianId = musicianId;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
}
