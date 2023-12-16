package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.User;
import com.example.bp_2023_2024.services.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @SessionAttributes("successMessage")
    public class UserThymeleafController {

        private final UserService userService;

        public UserThymeleafController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/users")
        public String userList(Model model) {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "users"; // Returns the Thymeleaf template name without extension
        }
        @GetMapping("/users/{id}")
        public String getUserById(@PathVariable String id, Model model) throws ChangeSetPersister.NotFoundException {
            User user = userService.getUserById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            model.addAttribute("user", user);
            return "userMore";
        }
        @GetMapping("/users/{id}/delete")
        public String deleteUser(@PathVariable String id) {
            userService.deleteUser(id);
            return "redirect:/users";
        }
        @GetMapping("/users/create")
        public String createUserForm(Model model) {
            model.addAttribute("newUser", new User());
            return "userCreate";
        }

        @PostMapping("/users/create")
        public String createUser(@ModelAttribute("newUser") User newUser,Model model) {
            model.addAttribute("successMessage", "User successfully created!");
            userService.createUser(newUser);
            return "redirect:/users";
        }

        @GetMapping("/users/{id}/edit")
        public String editUserForm(@PathVariable String id, Model model) throws ChangeSetPersister.NotFoundException {
            User user = userService.getUserById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            model.addAttribute("user", user);
            return "userEdit";
        }

        @PostMapping("/users/{id}/edit")
        public String editUser(@PathVariable String id, @ModelAttribute("user") User updatedUser) {
            // Validate and update the user
            userService.updateUser(updatedUser);
            return "redirect:/users";
        }

    }


