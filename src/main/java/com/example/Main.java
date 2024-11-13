package com.example;

import com.example.controllers.AuthController;
import com.example.controllers.UserController;
import com.example.controllers.LetterController;
import com.example.services.AuthService;
import com.example.services.UserService;
import com.example.services.LetterServiceImpl;
import com.example.views.LoginView;
import com.example.views.MainMenuView;
import com.example.views.MainMenuViewUser;
import com.example.views.UserListView;
import com.example.views.LetterListView;

public class Main {
    public static void main(String[] args) {
        // Services
        var authService = new AuthService();
        var userService = new UserService();
        var letterService = new LetterServiceImpl();

        // Views
        var loginView = new LoginView(null);
        var userListView = new UserListView();
        var letterListView = new LetterListView();

        // Controllers
        var userController = new UserController(userService, userListView, null);
        var letterController = new LetterController(letterService, letterListView);

        // Menus
        var mainMenuView = new MainMenuView(userController, letterController);
        var mainMenuViewUser = new MainMenuViewUser(letterController);

        // Set dependencies
        userController.setMainMenuView(mainMenuView);

        // AuthController
        var authController = new AuthController(authService, loginView, mainMenuView, mainMenuViewUser);
        loginView.setAuthController(authController);

        // Start application
        loginView.showLoginScreen();
    }
}
