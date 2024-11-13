package com.example.services;

import com.example.models.Letter;

import java.util.List;

public interface LetterService {
    List<Letter> getAllLetters();
    Letter getLetterById(int id);
    void createLetter(Letter letter);
    void updateLetter(Letter letter);
    void deleteLetter(int id);
}
