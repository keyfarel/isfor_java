package com.example.views;

import com.example.models.User;

import java.util.List;

public class UserListView {
    public void displayUsers(List<User> users) {
        System.out.println("Daftar Pengguna:");
        for (User user : users) {
            var roleName = (user.getRole() != null) ? user.getRole().getRoleName() : "No Role Assigned";
            System.out.printf("ID: %d, Username: %s, Email: %s, Role: %s%n",
                    user.getUserId(), user.getUsername(), user.getEmail(), roleName);
        }
    }
}
