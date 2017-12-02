package bgroig.musicianconnect.controllers;

import bgroig.musicianconnect.models.Musician;
import bgroig.musicianconnect.models.data.MusicianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;

/**
 * Created by bgroig on 7/4/2017.
 */
@Controller
@RequestMapping("musician")
public class MusicianController {

    @Autowired
    private MusicianDao musicianDao;


    @RequestMapping (value = "")
    public String index (Model model) {

        model.addAttribute("title", "Musician Connect");
        return "musician/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Musician());
        model.addAttribute("title", "Create an Account");
        return "musician/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Musician musician,
                      Errors errors, String verify,
                      Model model) {

        model.addAttribute("username", musician.getUsername());
        model.addAttribute("email", musician.getEmail());
        model.addAttribute("password", musician.getPassword());
        model.addAttribute("instruments", musician.getInstruments());
        model.addAttribute("description", musician.getDescription());
        model.addAttribute("location", musician.getLocation());

        musicianDao.save(musician);

        return "redirect:/musician/profile/" + musician.getId();
    }

    @RequestMapping(value = "profile/{musicianId}", method = RequestMethod.GET)
    public String profile(Model model, @PathVariable int musicianId){

        Musician musician = musicianDao.findOne(musicianId);

        model.addAttribute("musician", musician);
        model.addAttribute("title", musician.getUsername() + "'s Profile");
        return "musician/profile";
    }

    @RequestMapping (value = "login", method = RequestMethod.GET)
    public String login(Model model, Musician musician) {

        model.addAttribute("musician", musician);
        model.addAttribute("title", "Login");
        return "musician/login";

    }

    @RequestMapping (value = "login", method = RequestMethod.POST)
    public String login (@ModelAttribute @Valid Musician musician,
                         Errors errors, Model model, String verify) {

        model.addAttribute("musician", musician);
        boolean passwordsMatch = true;

        if (errors.hasErrors()) {
            return "musician/login";
        }

        if (musician.getPassword() == null || verify == null
                || !musician.getPassword().equals(verify)) {
            passwordsMatch = false;
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (passwordsMatch) {
            model.addAttribute("musician", musicianDao.findOne(musician.getId()));
            return "redirect:/musician/profile/" + musician.getId();

        }

        return "musician/profile";




    }

}
