package com.example.views;

import com.example.controllers.AuthController;
import lombok.Setter;

import java.util.Scanner;

@Setter
public class LoginView {
    private AuthController authController;

    public LoginView(AuthController authController) {
        this.authController = authController;
    }

    public void showLoginScreen() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        var username = scanner.nextLine();
        System.out.print("Enter Password: ");
        var password = scanner.nextLine();

        authController.handleLogin(username, password);
    }
}
