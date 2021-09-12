package com.physicsdefinitions.science.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Repositories.CurriculumRepository;
import com.physicsdefinitions.science.Repositories.MyUserRepo;
import com.physicsdefinitions.science.Repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserServiceImplementation implements MyUserService {
    @Autowired
    private MyUserRepo userRepo;
    @Autowired
    private RoleRepository roleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CurriculumRepository currRepo;

    public MyUserServiceImplementation(MyUserRepo userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder,
            CurriculumRepository currRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.currRepo = currRepo;
    }

    @Override
    public void saveUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // getting the get of the curriculum selected by the user.

        int id = user.getCurriculum().getId();

        // the get the curriculum

        Curriculum curr = currRepo.getById(id);

        // add the curriculum to the user

        user.setCurriculum(curr);

        userRepo.save(user);
        // adding a default role to the user-->USER
        addRoleToUser(user.getUsername(), "USER");

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        MyUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
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
