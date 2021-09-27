package com.physicsdefinitions.science.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
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
        try {
            MyUser checkUser = userRepo.findByUsername(user.getUsername());
            // checking if the user already exists
            if (checkUser != null && user.getUsername().equalsIgnoreCase(checkUser.getUsername())) {
                throw new ApiException("Username is taken.");
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                // checking if the foreign key object and the object property "id" for
                // curriculum was provided else we throw an error

                if (user.getCurriculum() == null || user.getCurriculum().getId() == 0) {
                    throw new ApiException("Curriculum field is required.");
                }

                // getting the id of the curriculum selected by the user.
                int id = user.getCurriculum().getId();

                // the get the curriculum

                Curriculum curr = currRepo.getById(id);

                // add the curriculum to the user

                user.setCurriculum(curr);

                userRepo.save(user);
                // adding a default role to the user-->USER
                addRoleToUser(user.getUsername(), "USER");
            }
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        MyUser user = userRepo.findByUsername(username);
        if (user == null) {
            throw new ApiException("Username does not exists.");
        }
        Role role = roleRepo.findByName(roleName);

        if (role == null) {
            throw new ApiException("RoleName does not exists.");
        }

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
        try {
            // checking if the role already exists
            Role roleCheck = roleRepo.findByName(role.getName());
            if (roleCheck != null && role.getName().equalsIgnoreCase(roleCheck.getName())) {
                throw new ApiException("Role already exists.");
            } else {
                roleRepo.save(role);
            }

        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }

}
