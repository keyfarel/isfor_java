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
    }
}
