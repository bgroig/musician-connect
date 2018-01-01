package bgroig.musicianconnect.Config;

/**
 * Created by bgroig on 12/19/2017.
 */

import bgroig.musicianconnect.models.Musician;
import bgroig.musicianconnect.models.data.MusicianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("musician");
        registry.addViewController("/musician").setViewName("musician");
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/musician/welcome").setViewName("welcome");
        registry.addViewController("/musician/addProfile").setViewName("addProfile");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/musician/login").setViewName("login");
        registry.addViewController("'/musician/profile/' + ${musicianId}").setViewName("profile");
        registry.addViewController("/musician/createEmail").setViewName("email");

    }

}