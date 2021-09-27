package com.physicsdefinitions.science.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
import com.physicsdefinitions.science.Models.MyUser;
import com.physicsdefinitions.science.Models.Role;
import com.physicsdefinitions.science.Repositories.MyUserRepo;
import com.physicsdefinitions.science.Services.MyUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {
    @Autowired
    private MyUserService userService;

    private MyUserRepo userRepo;

    public MyUserController(MyUserService userService, MyUserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;

    }

    // HOME URL
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<Object> goHome() {
        Map<String, Boolean> success = new HashMap<>();
        success.put("success", true);
        return new ResponseEntity<Object>(success, HttpStatus.OK);
    }

    @GetMapping("/users")
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

    // find the user by username and return the username else throw an exception
    @GetMapping("/user/{username}")
    @ResponseBody
    public ResponseEntity<Object> getUserByUsername(@PathVariable("username") String username) {
        MyUser user = userRepo.findByUsername(username);
        if (user == null) {
            throw new ApiException("User not found.");
        }
        return ResponseEntity.ok()
                .body(new viewUserForm(user.getId(), user.getFirstName(), user.getSecondName(), user.getUsername()));
    }

    @PostMapping("/user/save")
    @ResponseBody
    public ResponseEntity<Object> saveUser(@Valid @RequestBody MyUser user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User successfully added.\n");

    }

    @PostMapping("/role/save")
    @ResponseBody
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        userService.saveRole(role);
        return ResponseEntity.status(HttpStatus.OK).body("Role added.");
    }

    // add role to a
    @PostMapping("/user/add_role")
    @ResponseBody
    public ResponseEntity<Object> addRoleToUser(@Valid @RequestBody addRoleToUserData data) {
        userService.addRoleToUser(data.getUsername(), data.getRoleName());
        return ResponseEntity.status(HttpStatus.OK).body("Role added to user.");
    }

}

class addRoleToUserData {
    @NotBlank(message = "Username field is required.")
    private String username;
    @NotBlank(message = "Role name field is required.")
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

class viewUserForm {
    int id;
    String firstName;
    String secondName;
    String username;

    public viewUserForm() {

    }

    public viewUserForm(int id, String firstName, String secondName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
