package com.example.NodeDash.screens;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.NodeDash.R;
import com.example.NodeDash.fragments.NoteDetailFragment;

public class OpenNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open_note);

        // Get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String status = intent.getStringExtra("status");
        String dueDate = intent.getStringExtra("dueDate");
        String priority = intent.getStringExtra("priority");




        // Load NoteDetailFragment with the passed data
        NoteDetailFragment fragment = NoteDetailFragment.newInstance(title, description, status, dueDate, priority);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.openNoteFrame_container, fragment)
                .commit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}