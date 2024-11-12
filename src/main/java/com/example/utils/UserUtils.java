package com.example.utils;

import com.example.models.Role;
import com.example.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserUtils {

    // Membuat objek User dari ResultSet untuk mengurangi kode duplikat
    public static User mapResultSetToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("user_id"),
                rs.getString("username"),
                null, // password tidak disertakan untuk keamanan
                rs.getString("email"),
                RoleUtils.getRoleById(rs.getInt("role_id")) // Menggunakan RoleUtils
        );
    }
}
