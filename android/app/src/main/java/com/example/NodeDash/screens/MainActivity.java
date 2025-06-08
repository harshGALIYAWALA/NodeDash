package com.example.NodeDash.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.NodeDash.R;
import com.example.NodeDash.fragments.NoteDetailFragment;
import com.example.NodeDash.fragments.notes_fragment;
import com.example.NodeDash.fragments.todo_fragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class  MainActivity extends AppCompatActivity {

    BottomNavigationView btnNavView;
    FrameLayout frame_layout;
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnNavView = findViewById(R.id.btnNavView);
        frame_layout = findViewById(R.id.frame_layout);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        floatingActionBtn = findViewById(R.id.floatingActionBtn);


        // bottomNavView
        btnNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.menu_note) {
                    loadFrag(new notes_fragment(), false);
                } else {
                    loadFrag(new todo_fragment(), true);
                }

                return true;
            }
        });

        btnNavView.setSelectedItemId(R.id.menu_note);


        floatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OpenNoteActivity.class);

                // Pass empty fields for creating a new note
                intent.putExtra("title", "");
                intent.putExtra("description", "");
                intent.putExtra("status", "pending");
                intent.putExtra("dueDate", "");
                intent.putExtra("priority", "low");

                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.frame_layout, fragment);
        } else {
            ft.replace(R.id.frame_layout, fragment);
        }
        ft.commit();

    }

}