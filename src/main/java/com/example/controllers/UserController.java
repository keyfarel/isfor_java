package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.services.UserService;
import com.example.views.MainMenuView;
import com.example.views.UserListView;
import lombok.Setter;

import java.util.Scanner;

@Setter
public class UserController {
    private UserService userService;
    private UserListView userListView;
    private MainMenuView mainMenuView;
    private Scanner scanner = new Scanner(System.in);

    public UserController(UserService userService, UserListView userListView, MainMenuView mainMenuView) {
        this.userService = userService;
        this.userListView = userListView;
        this.mainMenuView = mainMenuView;
    }

    public void viewUsers() {
        userListView.displayUsers(userService.getAllUsers());
    }

    public void addUser() {
        User newUser = new User();

        System.out.print("Enter Username: ");
        newUser.setUsername(scanner.nextLine());

        System.out.print("Enter Password: ");
        newUser.setPassword(scanner.nextLine());

        System.out.print("Enter Email: ");
        newUser.setEmail(scanner.nextLine());

        System.out.print("Enter Role (ADMIN/USER): ");
        String roleName = scanner.nextLine().toUpperCase();
        int roleId = userService.getRoleIdByName(roleName);

        if (roleId != -1) {
            Role role = new Role();
            role.setRoleId(roleId);
            role.setRoleName(roleName);
            newUser.setRole(role);

            userService.createUser(newUser);
            System.out.println("User berhasil ditambahkan.");
        } else {
            System.out.println("Role tidak ditemukan.");
        }
    }


    public void editUser() {
        System.out.print("Enter User ID to edit: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User existingUser = userService.getUserById(userId);
        if (existingUser != null) {
            System.out.print("Enter new Username: ");
            existingUser.setUsername(scanner.nextLine());

            System.out.print("Enter new Password: ");
            existingUser.setPassword(scanner.nextLine());

            System.out.print("Enter new Email: ");
            existingUser.setEmail(scanner.nextLine());

            userService.updateUser(existingUser);
            System.out.println("User berhasil diperbarui.");
        } else {
            System.out.println("User tidak ditemukan.");
        }
    }

    public void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        int userId = scanner.nextInt();

        userService.deleteUser(userId);
        System.out.println("User berhasil dihapus.");
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }
}
