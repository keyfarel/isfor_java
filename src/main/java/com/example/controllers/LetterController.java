package com.example.controllers;

import com.example.models.Letter;
import com.example.services.LetterService;
import com.example.views.LetterListView;

import java.util.Scanner;

public class LetterController {
    private final LetterService letterService;
    private final LetterListView letterListView;
    private final Scanner scanner = new Scanner(System.in);

    public LetterController(LetterService letterService, LetterListView letterListView) {
        this.letterService = letterService;
        this.letterListView = letterListView;
    }

    public void createLetter() {
        Letter letter = new Letter();
        System.out.print("Enter Letter Title: ");
        letter.setTitle(scanner.nextLine());
        System.out.print("Enter Letter Content: ");
        letter.setContent(scanner.nextLine());

        letterService.createLetter(letter);
        System.out.println("Letter created successfully.");
    }

    public void viewLetters() {
        letterListView.displayLetters(letterService.getAllLetters());
    }
}
