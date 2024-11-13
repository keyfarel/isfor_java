package com.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    public static String encryptPassword(String password) {
        try {
            var md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            var hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String inputPassword, String encryptedPassword) {
        var hashedInput = encryptPassword(inputPassword);
        return hashedInput.equals(encryptedPassword);
    }
}
