package bgroig.musicianconnect.controllers;

import bgroig.musicianconnect.models.Email;
import bgroig.musicianconnect.models.Musician;
import bgroig.musicianconnect.models.data.MusicianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by bgroig on 12/28/2017.
 */
@Controller
@RequestMapping("musician")
public class EmailController {

    @Autowired
    private MusicianDao musicianDao;

    @RequestMapping(value = "createEmail", method = RequestMethod.GET)
    public String sendEmail(Model model){

        model.addAttribute(new Email());
        model.addAttribute("musicians", musicianDao.findAll());
        model.addAttribute("title", "Email");

        return "musician/createEmail";

    }

    @RequestMapping(value = "createEmail", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute @Valid Email newEmail,
                            Model model, Errors errors,
                            @RequestParam int musicianId){

        Musician musician = musicianDao.findOne(musicianId);
        newEmail.setTo(musician.getUsername());

        if(errors.hasErrors()){
            model.addAttribute("title", "Email");
            return "musician/createEmail";
        }

        return "redirect:";
    }


}
