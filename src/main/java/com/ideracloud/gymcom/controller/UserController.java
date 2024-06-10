package com.ideracloud.gymcom.controller;

import com.ideracloud.gymcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation for REST API controllers
@RequestMapping("/users") // Base path for user-related endpoints
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')")
    @GetMapping("/count") // Endpoint to get user count
    public Integer getUserCount() {
        return userService.countUsers();
    }
}
