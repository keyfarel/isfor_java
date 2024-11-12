package com.example.controllers;

import com.example.models.User;
import com.example.services.AuthService;
import com.example.views.LoginView;

public class AuthController {
    private final AuthService authService;
    private final LoginView loginView;

    public AuthController(AuthService authService, LoginView loginView) {
        this.authService = authService;
        this.loginView = loginView;
    }

    public void handleLogin(String username, String password) {
        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Login successful for user: " + user.getUsername());

            if (user.getRole() != null && "admin".equalsIgnoreCase(user.getRole().getRoleName())) {
                System.out.println("Admin access granted.");
            } else if (user.getRole() != null) {
                System.out.println("User access granted.");
            } else {
                System.out.println("Role not assigned to the user.");
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }


    public void handleLogout() {
        authService.logout();
    }
}