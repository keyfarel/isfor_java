package com.example.views;

import com.example.models.Letter;

import java.util.List;

public class LetterListView {
    public void displayLetters(List<Letter> letters) {
        if (letters.isEmpty()) {
            System.out.println("Tidak ada surat untuk ditampilkan.");
        } else {
            for (Letter letter : letters) {
                System.out.println("ID: " + letter.getId());
                System.out.println("Title: " + letter.getTitle());
                System.out.println("Description: " + letter.getDescription());
                System.out.println("Recipient: " + letter.getRecipient());
                System.out.println("Status: " + letter.getStatus());
                System.out.println("----------------------------");
            }
        }
    }
}
