package com.physicsdefinitions.science.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;

import org.springframework.stereotype.Service;

@Service
@Transactional
public interface MyUserService {
    public List<MyUser> getUsers();

    public List<Role> getRoles();

    public void saveUser(MyUser user);

    public void addRoleToUser(String username, String roleName);

    public void saveRole(Role role);

}
