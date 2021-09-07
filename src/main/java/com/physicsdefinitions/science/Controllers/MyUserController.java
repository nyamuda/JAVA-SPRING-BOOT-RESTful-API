package com.physicsdefinitions.science.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Services.MyUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<List<MyUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/roles")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(userService.getRoles());
    }

    @PostMapping("/users/save")
    @ResponseBody
    public ResponseEntity<Object> saveUser(@Valid @RequestBody MyUser user) {

        try {
            userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("User successfully added.\n");
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            Map<String, String> errorInfo = new HashMap<>();
            Map<String, Map<String, String>> errorBody = new HashMap<>();
            errorInfo.put("username", "Username has been taken.");
            errorBody.put("errors", errorInfo);

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorBody);
        }

    }

    @PostMapping("/roles/save")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        userService.saveRole(role);
        return ResponseEntity.status(HttpStatus.OK).body("Role added.");
    }

    @PostMapping("/users/add_role")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Object> addRoleToUser(@RequestBody addRoleToUserData data) {
        userService.addRoleToUser(data.getUsername(), data.getRoleName());
        return ResponseEntity.status(HttpStatus.OK).body("Role added to user.");
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
