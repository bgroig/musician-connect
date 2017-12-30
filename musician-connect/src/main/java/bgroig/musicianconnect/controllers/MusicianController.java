package bgroig.musicianconnect.controllers;

import bgroig.musicianconnect.models.Musician;
import bgroig.musicianconnect.models.data.MusicianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    }@RequestMapping(value = "addProfile", method = RequestMethod.GET)
    public String register(Model model){

        model.addAttribute(new Musician());
        model.addAttribute("title", "Register");

        return "musician/addProfile";

    }

    @RequestMapping(value = "addProfile", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Musician musician,
                      Errors errors,
                      Model model) {

        model.addAttribute("username", musician.getUsername());
        model.addAttribute("password", musician.getPassword());
        model.addAttribute("instruments", musician.getInstruments());
        model.addAttribute("musicStyles", musician.getMusicStyles());
        model.addAttribute("location", musician.getLocation());
        model.addAttribute("ability", musician.getAbility());

        musicianDao.save(musician);

        return "redirect:/musician/profile/" + musician.getId();
    }

    @RequestMapping(value = "profile/{musicianId}", method = RequestMethod.GET)
    public String profile(Model model, @PathVariable int musicianId){

        Musician musician = musicianDao.findOne(musicianId);
        model.addAttribute("title", musician.getUsername() + "'s Profile");
        model.addAttribute("musician", musician);
        return "musician/profile";
    }


}
