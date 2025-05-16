package com.example.flashcardsapp  // Replace with your actual package name

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var flashcardTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var addButton: Button
    private lateinit var deleteButton: Button

    private val flashcards = mutableListOf<String>()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashcardTextView = findViewById(R.id.flashcardTextView)
        nextButton = findViewById(R.id.nextButton)
        addButton = findViewById(R.id.addButton)
        deleteButton = findViewById(R.id.deleteButton)

        // Next flashcard
        nextButton.setOnClickListener {
            if (flashcards.isNotEmpty()) {
                currentIndex = (currentIndex + 1) % flashcards.size
                flashcardTextView.text = flashcards[currentIndex]
            } else {
                flashcardTextView.text = "No flashcards yet"
            }
        }

        // Add flashcard
        addButton.setOnClickListener {
            val editText = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("Add Flashcard")
                .setMessage("Enter the flashcard content:")
                .setView(editText)
                .setPositiveButton("Add") { _, _ ->
                    val input = editText.text.toString()
                    if (input.isNotEmpty()) {
                        flashcards.add(input)
                        flashcardTextView.text = input
                        currentIndex = flashcards.size - 1
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        // Delete all flashcards
        deleteButton.setOnClickListener {
            flashcards.clear()
            flashcardTextView.text = "All flashcards deleted"
            currentIndex = 0
        }
    }
}
