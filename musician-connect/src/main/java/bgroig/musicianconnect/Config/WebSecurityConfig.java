package bgroig.musicianconnect.Config;

/**
 * Created by bgroig on 12/19/2017.
 */

import bgroig.musicianconnect.models.Musician;
import bgroig.musicianconnect.models.data.MusicianDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.ModelAttribute;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/musician",  "/musician/addProfile", "/musician/createEmail").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("John").password("john").roles("USER");
        auth
                .inMemoryAuthentication()
                .withUser("Ben").password("ben").roles("USER");
        auth
                .inMemoryAuthentication()
                .withUser("Kate").password("kate").roles("USER");

    }
}