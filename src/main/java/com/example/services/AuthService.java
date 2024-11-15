package com.example.services;

import com.example.models.Role;
import com.example.models.User;
import com.example.utils.DatabaseConnection;
import com.example.utils.PasswordUtils;
import com.example.utils.RoleUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public User login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT u.*, r.role_id, r.role_name " +
                    "FROM users u " +
                    "JOIN role r ON u.role_id = r.role_id " +
                    "WHERE u.username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");

                if (PasswordUtils.verifyPassword(password, encryptedPassword)) {
                    Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
                    return new User(rs.getInt("user_id"), username, encryptedPassword, rs.getString("email"), role);
                }
            }
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }
}
