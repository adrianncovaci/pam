package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private val ADD_TASK_REQUEST = 1
    private lateinit var listView: ListView
    private val notesList: MutableList<String> = mutableListOf()
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.list_view)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notesList)
        val newNoteBtn = findViewById<Button>(R.id.btn_add_note)
        newNoteBtn.setOnClickListener { addTaskClicked() }
    }

    fun addTaskClicked() {
        val intent = Intent(this, NoteDescriptionActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val task = data?.getStringExtra(NoteDescriptionActivity.EXTRA_NOTE_DESCRIPTION)
                task?.let {
                    notesList.add(task)
                    listView.adapter = adapter
                }
            }
        }
    }
}