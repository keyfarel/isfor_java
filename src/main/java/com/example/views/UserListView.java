package com.example.views;

import com.example.models.User;

import java.util.List;

public class UserListView {
    public void displayUsers(List<User> users) {
        System.out.println("Daftar Pengguna:");
        for (User user : users) {
            System.out.printf("ID: %d, Username: %s, Email: %s, Role: %s%n",
                    user.getUserId(), user.getUsername(), user.getEmail(), user.getRole().getRoleName());
        }
    }
}
