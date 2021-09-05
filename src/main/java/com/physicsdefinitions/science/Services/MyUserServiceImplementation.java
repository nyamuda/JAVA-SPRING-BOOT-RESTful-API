package com.physicsdefinitions.science.Services;

import java.util.List;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Repositories.MyUserRepo;
import com.physicsdefinitions.science.Repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MyUserServiceImplementation implements MyUserService {
    @Autowired
    private MyUserRepo userRepo;
    @Autowired
    private RoleRepository roleRepo;

    public MyUserServiceImplementation(MyUserRepo userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void saveUser(MyUser user) {
        userRepo.save(user);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        MyUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public List<MyUser> getUsers() {

        return userRepo.findAll();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);

    }

}
