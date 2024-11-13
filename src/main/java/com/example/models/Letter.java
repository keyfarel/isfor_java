package com.example.models;

import lombok.Data;

@Data
public class Letter {
    private int id;
    private String title;
    private String description;
    private String recipient;
    private LetterStatus status;

    public void setContent(String s) {
    }
}
