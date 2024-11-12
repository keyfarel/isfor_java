package com.example.services;

import com.example.models.User;
import com.example.utils.DatabaseConnection;
import com.example.utils.PasswordUtils;
import com.example.utils.UserUtils;
import com.example.utils.RoleUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        var query = "SELECT * FROM users";

        try (var conn = DatabaseConnection.getConnection();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                users.add(UserUtils.mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all users: " + e.getMessage());
        }
        return users;
    }

    public void createUser(User user) {
        var query = "INSERT INTO users (username, password, email, role_id) VALUES (?, ?, ?, ?)";

        try (var conn = DatabaseConnection.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, PasswordUtils.encryptPassword(user.getPassword()));
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getRole().getRoleId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    public int getRoleIdByName(String roleName) {
        return RoleUtils.getRoleIdByName(roleName);
    }

    public User getUserById(int userId) {
        var query = "SELECT * FROM users WHERE user_id = ?";
        try (var conn = DatabaseConnection.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                return UserUtils.mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching user by ID: " + e.getMessage());
        }
        return null;
    }

    public void updateUser(User user) {
        var query = "UPDATE users SET username = ?, password = ?, email = ?, role_id = ? WHERE user_id = ?";

        try (var conn = DatabaseConnection.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, PasswordUtils.encryptPassword(user.getPassword()));
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getRole().getRoleId());
            stmt.setInt(5, user.getUserId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        var query = "DELETE FROM users WHERE user_id = ?";
        try (var conn = DatabaseConnection.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}
