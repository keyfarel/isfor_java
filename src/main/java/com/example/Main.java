package com.example;

import com.example.controllers.AuthController;
import com.example.controllers.UserController;
import com.example.services.AuthService;
import com.example.services.UserService;
import com.example.views.LoginView;
import com.example.views.MainMenuView;
import com.example.views.UserListView;

public class Main {
    public static void main(String[] args) {
        var authService = new AuthService();
        var userService = new UserService();
        var loginView = new LoginView(null);
        var userListView = new UserListView();
        var userController = new UserController(userService, userListView, null);

        // Inisialisasi MainMenuView setelah userController dibuat
        var mainMenuView = new MainMenuView(userController);

        // Set mainMenuView ke userController
        userController.setMainMenuView(mainMenuView);

        var authController = new AuthController(authService, loginView, mainMenuView);
        loginView.setAuthController(authController);

        loginView.showLoginScreen();
    }
}
