package com.example.TEST.web.rest;

import com.example.TEST.domain.Roles;
import com.example.TEST.domain.Users;
import com.example.TEST.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }
    @PostMapping("/user-save")
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {
        return ResponseEntity.ok().body(userService.saveUser(users));
    }
    @PostMapping("/role-save")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles roles) {
        return ResponseEntity.ok().body(userService.saveRole(roles));
    }
    @PostMapping("/role-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}
