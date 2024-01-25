package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.User;
import com.example.bp_2023_2024.models.UserRole;
import com.example.bp_2023_2024.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path="createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user,@RequestParam UserRole newRole) {
        if (!user.getUserId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        User updatedUser = userService.updateUser(id,user);
       // userService.updateUserRole(id,newRole);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
//    @PatchMapping("/{userId}/update-role")
//    public ResponseEntity<String> updateUserRole(
//            @PathVariable Long userId,
//            @RequestParam UserRole newRole) {
//
//        userService.updateUserRole(userId, newRole);
//        return new ResponseEntity<>("User role updated successfully", HttpStatus.OK);
//    }
}
