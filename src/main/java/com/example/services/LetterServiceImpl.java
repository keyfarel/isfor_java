package com.example.services;

import com.example.models.Letter;

import java.util.ArrayList;
import java.util.List;

public class LetterServiceImpl implements LetterService {
    private final List<Letter> letters = new ArrayList<>();

    @Override
    public void createLetter(Letter letter) {
        letters.add(letter);
    }

    @Override
    public void updateLetter(Letter letter) {

    }

    @Override
    public void deleteLetter(int id) {

    }

    @Override
    public List<Letter> getAllLetters() {
        return letters;
    }

    @Override
    public Letter getLetterById(int id) {
        return null;
    }
}
