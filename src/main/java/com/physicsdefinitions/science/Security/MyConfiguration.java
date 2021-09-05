package com.physicsdefinitions.science.Security;

import com.physicsdefinitions.science.Services.UserDetailsImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsImplementation userDetails;

    public MyConfiguration(PasswordEncoder passwordEncoder, UserDetailsImplementation userDetails) {
        this.passwordEncoder = passwordEncoder;
        this.userDetails = userDetails;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // telling the authenticationManger how the user user should be authenticated
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
    }
}
