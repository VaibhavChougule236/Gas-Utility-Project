package com.GasUtility.controller;

import com.GasUtility.entity.ServiceRequest;
import com.GasUtility.entity.User;
import com.GasUtility.service.ServiceRequestService;
import com.GasUtility.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService requestService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> userOptional = userService.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get(); // Extracting the User object
            List<ServiceRequest> requests = requestService.getRequestsByUserId(user.getId());
            model.addAttribute("username", username);
            model.addAttribute("requests", requests);
        } else {
            model.addAttribute("error", "User not found.");
        }

        return "dashboard";
    }
}
