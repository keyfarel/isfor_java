package com.example.views;

import com.example.controllers.LetterController;

import java.util.Scanner;

public class MainMenuViewUser {
    private final LetterController letterController;

    public MainMenuViewUser(LetterController letterController) {
        this.letterController = letterController;
    }

    public void showUserMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Create Letter");
            System.out.println("2. View Letters");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> letterController.createLetter();
                case 2 -> letterController.viewLetters();
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
