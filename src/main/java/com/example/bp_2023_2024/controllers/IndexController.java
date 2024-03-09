package com.example.bp_2023_2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Main Page");
        return "indexAdmin";
    }

    @Controller
    public class AboutController {
        @GetMapping("/about")
        public String main(Model model) {
            model.addAttribute("about", "About Page");
            return "about";
        }
    }
    @Controller
    public class ErrorController {
        @GetMapping("/error")
        public String main(Model model) {
            model.addAttribute("error", "Error Page");
            return "error";
        }
    }

    @GetMapping("/user/indexUser")
    public String userDashboard() {
        return "indexUser";
    }

    @GetMapping("/admin/indexAdmin")
    public String adminDashboard() {
        return "indexAdmin";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }




}

