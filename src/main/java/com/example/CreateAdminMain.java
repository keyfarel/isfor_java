package com.example;

import com.example.models.Role;
import com.example.models.User;
import com.example.services.UserService;

public class CreateAdminMain {
    public static void main(String[] args) {
        var userService = new UserService();

        // Membuat objek User baru untuk admin
        var adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("123"); // Pastikan password cukup kuat dalam produksi
        adminUser.setEmail("admin@example.com");

        // Mengatur role sebagai ADMIN
        var adminRole = new Role();
        adminRole.setRoleId(1); // Sesuaikan ID dengan role "ADMIN" di database
        adminUser.setRole(adminRole);

        // Menyimpan admin ke database
        userService.createUser(adminUser);
        System.out.println("Admin baru berhasil dibuat.");

        // Membuat objek User baru untuk user biasa
        var regularUser = new User();
        regularUser.setUsername("user");
        regularUser.setPassword("user123"); // Pastikan password cukup kuat dalam produksi
        regularUser.setEmail("user@example.com");

        // Mengatur role sebagai USER
        var userRole = new Role();
        userRole.setRoleId(2); // Sesuaikan ID dengan role "USER" di database
        regularUser.setRole(userRole);

        // Menyimpan regular user ke database
        userService.createUser(regularUser);
        System.out.println("User biasa baru berhasil dibuat.");
    }
}
