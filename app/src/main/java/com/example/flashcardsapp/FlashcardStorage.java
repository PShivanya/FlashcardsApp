package com.example.flashcardsapp;

import java.util.ArrayList;
import java.util.List;

public class FlashcardStorage {
    private static List<Flashcard> flashcards = new ArrayList<>();

    public static void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public static List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public static void removeFlashcard(int index) {
        if (index >= 0 && index < flashcards.size()) {
            flashcards.remove(index);
        }
    }
}

