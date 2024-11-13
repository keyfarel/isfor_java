package com.example.views;

import com.example.controllers.UserController;

import java.util.Scanner;

public class MainMenuView {
    private final UserController userController;

    public MainMenuView(UserController userController) {
        this.userController = userController;
    }

    public int showAdminMenu() {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View All Users");
            System.out.println("2. Create New User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            var choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userController.viewUsers();
                case 2 -> userController.addUser();
                case 3 -> userController.editUser();
                case 4 -> userController.deleteUser();
                case 5 -> {
                    System.out.println("Logging out...");
                    return -1;  // Signal for logout
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void showUserMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("User Menu:");
        System.out.println("1. Logout");
        var choice = scanner.nextInt();
        if (choice == 1) {
            userController.logout();
        }
    }
}
