// LoginView.java
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        authController.handleLogin(username, password);
    }
}
