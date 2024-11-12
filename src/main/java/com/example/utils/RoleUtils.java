package com.example.utils;

import com.example.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleUtils {

    // Mengambil Role berdasarkan ID dari database
    public static Role getRoleById(int roleId) {
        var query = "SELECT * FROM role WHERE role_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, roleId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Role(roleId, rs.getString("role_name"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching role by ID: " + e.getMessage());
        }
        return null;
    }

    // Mengambil Role ID berdasarkan nama role
    public static int getRoleIdByName(String roleName) {
        var query = "SELECT role_id FROM role WHERE role_name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, roleName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("role_id");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching role ID by name: " + e.getMessage());
        }
        return -1;
    }
}
