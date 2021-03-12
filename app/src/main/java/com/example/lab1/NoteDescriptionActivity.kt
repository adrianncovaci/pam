package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.Activity
import android.content.Intent
import android.widget.EditText


class NoteDescriptionActivity : AppCompatActivity() {
    companion object {
        val EXTRA_NOTE_DESCRIPTION = "note"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_description)
    }

    fun doneClicked(view: View) {
        val text: EditText = findViewById(R.id.descriptionText)
        val taskDescription = text.text.toString()

        if (!taskDescription.isEmpty()) {
            val result = Intent()
            result.putExtra(EXTRA_NOTE_DESCRIPTION, taskDescription)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()

    }
}