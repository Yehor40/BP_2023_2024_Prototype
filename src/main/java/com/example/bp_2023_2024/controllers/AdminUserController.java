//package com.example.bp_2023_2024.controllers;
//
//import com.example.bp_2023_2024.models.User;
//import com.example.bp_2023_2024.services.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin/users") // Restrict to admin role
//public class AdminUserController {
//
//    private UserService userService;
//
//    @PreAuthorize("hasRole('ADMIN') and principal.isAdmin") // Check if the user is admin
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User newUser = userService.createUser(user);
//        return ResponseEntity.ok(newUser);
//    }
//
//    @PreAuthorize("hasRole('ADMIN') and principal.isAdmin") // Check if the user is admin
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
//        if (!user.getUserId().equals(id)) {
//            return ResponseEntity.badRequest().build();
//        }
//        User updatedUser = userService.updateUser(user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @PreAuthorize("hasRole('ADMIN') and principal.isAdmin") // Check if the user is admin
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
