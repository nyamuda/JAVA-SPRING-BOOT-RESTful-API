package com.physicsdefinitions.science.Services;

import java.util.ArrayList;
import java.util.Collection;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Repositories.MyUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplementation implements UserDetailsService {
    @Autowired
    private MyUserRepo userRepo;

    public UserDetailsImplementation(MyUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Incorrect credentials");
        }
        // creating an empty arrayList;
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // we loop through the roles of the user and convert each role name to a
        // SimpleGrantedAuthority;
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new User(user.getUsername(), user.getPassword(), authorities);

    }
}
