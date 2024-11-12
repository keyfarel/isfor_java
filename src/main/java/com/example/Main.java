// Main.java
package com.example;

import com.example.controllers.AuthController;
import com.example.services.AuthService;
import com.example.views.LoginView;

public class Main {
    public static void main(String[] args) {
        var authService = new AuthService();
        var loginView = new LoginView(null);
        var authController = new AuthController(authService, loginView);

        loginView.setAuthController(authController);

        loginView.showLoginScreen();
    }
}
