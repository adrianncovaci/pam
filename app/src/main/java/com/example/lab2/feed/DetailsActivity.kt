package com.example.lab2.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lab2.R

class DetailsActivity : AppCompatActivity() {
    lateinit var text1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        text1 = findViewById<TextView>(R.id.id)

        if (intent.hasExtra("id")) {
            text1.text = intent.getStringExtra("id")
        }
    }
}