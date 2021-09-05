package com.physicsdefinitions.science.Controllers;

import java.util.List;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Services.MyUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {
    @Autowired
    private MyUserService userService;

    public MyUserController(MyUserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<MyUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/roles")
    @ResponseBody
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(userService.getRoles());
    }

    @PostMapping("/users/save")
    @ResponseBody
    public ResponseEntity<MyUser> saveUser(@RequestBody MyUser user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/roles/save")
    @ResponseBody
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @PostMapping("/users/add_role")
    @ResponseBody
    public void addRoleToUser(@RequestBody addRoleToUserData data) {
        userService.addRoleToUser(data.getUsername(), data.getRoleName());
    }

}

class addRoleToUserData {
    private String username;
    private String roleName;

    public addRoleToUserData() {

    }

    public String getRoleName() {
        return roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
