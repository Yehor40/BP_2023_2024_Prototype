package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.Task_Details;
import com.example.bp_2023_2024.models.Project;
import com.example.bp_2023_2024.models.Project_Task;
import com.example.bp_2023_2024.models.User;
import com.example.bp_2023_2024.services.DetailsService;
import com.example.bp_2023_2024.services.ProjectService;
import com.example.bp_2023_2024.services.TaskService;
import com.example.bp_2023_2024.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

    @Controller
    @SessionAttributes("successMessage")
    public class UserThymeleafController {
        @Autowired
        private final UserService userService;
        private final TaskService taskService;
        private final DetailsService detailsService;
        private final ProjectService projectService;

        public UserThymeleafController(UserService userService, TaskService taskService, DetailsService detailsService, ProjectService projectService) {
            this.userService = userService;
            this.taskService = taskService;
            this.detailsService = detailsService;
            this.projectService = projectService;
        }
        @GetMapping("/users/{id}/userActivities")
        public String activitiesList(Model model, @PathVariable Long id){
            User user=userService.getUserById(id).orElseThrow();
            List<Project_Task>tasks = taskService.getAllTasks();
            List<Task_Details>details = detailsService.getAllDetails();
            List<Project>projects = projectService.getAllProjects();
           // List<User>users=userService.getAllUsers();
            model.addAttribute("users",user);
            model.addAttribute("tasks",tasks);
            model.addAttribute("details",details);
            model.addAttribute("projects",projects);
            return "userActivities";
        }


        @GetMapping("/users")
        public String userList(Model model) {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "users"; // Returns the Thymeleaf template name without extension
        }
        @GetMapping("/users/{id}")
        public String getUserById(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {
            User user = userService.getUserById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            model.addAttribute("user", user);
            return "userMore";
        }
        @GetMapping("/users/{id}/delete")
        public String deleteUser(@PathVariable Long id) {
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

            userService.createUser(newUser);
            return "redirect:/users";
        }

        @GetMapping("/users/{id}/edit")
        public String editUserForm(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {
            User user = userService.getUserById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            model.addAttribute("user", user);
            return "userEdit";
        }

        @PostMapping("/users/{id}/edit")
        public String editUser(@PathVariable Long id,
                               @ModelAttribute("user") User updatedUser,
                               RedirectAttributes redirectAttributes) {
            // Validate and update the user

            try {
                userService.updateUser(id, updatedUser);
            } catch (EntityNotFoundException e) {
                // Handle the case where the user is not found
            }

            return "redirect:/users";
        }


    }


