package com.physicsdefinitions.science.Security;

import javax.annotation.PostConstruct;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Services.MyUserServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//ADDING A DEFAULT ADMIN
@Component
public class DbInit {
    @Autowired
    private MyUserServiceImplementation userServiceImplementation;

    public DbInit(MyUserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }

    @PostConstruct
    private void postConstruct() {
        MyUser admin = new MyUser("admin", "12345678", "admin", "admin");
        userServiceImplementation.saveUser(admin);
        userServiceImplementation.saveRole(new Role("ADMIN"));

        userServiceImplementation.addRoleToUser("admin", "ADMIN");

    }

}
