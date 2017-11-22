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

        model.addAttribute("musician", musician);
        return "redirect:/musician/profile/";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model, Musician musician) {


        model.addAttribute("title", "Profile");
        return "musician/profile";
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String profile(@ModelAttribute @Valid Musician musician,
                         Errors errors, Model model) {

        musicianDao.save(musician);
        return "redirect:";

    }

    @RequestMapping (value = "login", method = RequestMethod.GET)
    public String login(Model model, Musician musician) {

        model.addAttribute("musician", musician);
        model.addAttribute("title", "Login");
        return "musician/login";

    }

    @RequestMapping (value = "login", method = RequestMethod.POST)
    public String login (@ModelAttribute @Valid Musician musician,
                         Errors errors, Model model) {

        musicianDao.findOne(musician.getId());
        return "redirect:/musician/profile/" + musician.getId();


    }

}
