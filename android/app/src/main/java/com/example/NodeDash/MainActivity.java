package com.example.NodeDash;

import android.os.Bundle;
import android.view.MenuItem;
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
import com.example.NodeDash.fragments.notes_fragment;
import com.example.NodeDash.fragments.todo_fragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  MainActivity extends AppCompatActivity {

    BottomNavigationView btnNavView;
    FrameLayout frame_layout;
    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnNavView = findViewById(R.id.btnNavView);
        frame_layout = findViewById(R.id.frame_layout);
        bottomAppBar = findViewById(R.id.bottomAppBar);


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