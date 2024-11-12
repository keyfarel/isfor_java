package com.example.controllers;

import com.example.models.User;
import com.example.services.AuthService;
import com.example.views.LoginView;
import com.example.views.MainMenuView;

public class AuthController {
    private final AuthService authService;
    private final LoginView loginView;
    private final MainMenuView mainMenuView;

    public AuthController(AuthService authService, LoginView loginView, MainMenuView mainMenuView) {
        this.authService = authService;
        this.loginView = loginView;
        this.mainMenuView = mainMenuView;
    }

    public void handleLogin(String username, String password) {
        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Login successful for user: " + user.getUsername());

            if (user.getRole() != null && "admin".equalsIgnoreCase(user.getRole().getRoleName())) {
                System.out.println("Admin access granted.");
                mainMenuView.showAdminMenu(); // Menampilkan menu admin
            } else if (user.getRole() != null) {
                System.out.println("User access granted.");
                mainMenuView.showUserMenu(); // Menampilkan menu user
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
