package com.example.controllers;

import com.example.models.User;
import com.example.services.AuthService;
import com.example.views.LoginView;
import com.example.views.MainMenuView;
import com.example.views.MainMenuViewUser;

public class AuthController {
    private final AuthService authService;
    private final LoginView loginView;
    private final MainMenuView mainMenuView;
    private final MainMenuViewUser mainMenuViewUser;

    public AuthController(AuthService authService, LoginView loginView, MainMenuView mainMenuView, MainMenuViewUser mainMenuViewUser) {
        this.authService = authService;
        this.loginView = loginView;
        this.mainMenuView = mainMenuView;
        this.mainMenuViewUser = mainMenuViewUser;
    }

    public void handleLogin(String username, String password) {
        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Login successful for user: " + user.getUsername());
            if ("admin".equalsIgnoreCase(user.getRole().getRoleName())) {
                mainMenuView.showAdminMenu();
            } else {
                mainMenuViewUser.showUserMenu();
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
