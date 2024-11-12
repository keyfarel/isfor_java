package com.example.services;

import com.example.models.Role;
import com.example.models.User;
import com.example.utils.DatabaseConnection;
import com.example.utils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public User login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Query dengan join ke tabel roles
            String query = "SELECT u.*, r.role_id, r.role_name " +
                    "FROM users u " +
                    "JOIN role r ON u.role_id = r.role_id " +
                    "WHERE u.username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Mendapatkan password terenkripsi dari database
                String encryptedPassword = rs.getString("password");

                // Verifikasi password yang diinputkan dengan password terenkripsi
                if (PasswordUtils.verifyPassword(password, encryptedPassword)) {
                    // Jika cocok, buat objek User dan Role, lalu kembalikan
                    User user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(encryptedPassword); // Simpan password terenkripsi
                    user.setEmail(rs.getString("email"));

                    // Inisialisasi Role
                    Role role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));

                    // Set Role ke User
                    user.setRole(role);

                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Login gagal
    }


    public void logout() {
        System.out.println("Logged out successfully.");
    }
}