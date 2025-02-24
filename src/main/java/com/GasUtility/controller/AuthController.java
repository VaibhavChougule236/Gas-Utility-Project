package com.GasUtility.controller;

import com.GasUtility.entity.User;
import com.GasUtility.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        return userService.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> "redirect:/dashboard")
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid credentials");
                    return "login";
                });
    }
}
