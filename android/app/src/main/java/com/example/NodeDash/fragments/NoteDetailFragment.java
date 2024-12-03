package com.example.NodeDash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.NodeDash.R;

public class NoteDetailFragment extends Fragment {



    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_DATE = "date";
    private static final String ARG_STATUS = "status";
    private static final String ARG_PRIORITY = "priority";

    private String title;
    private String description;
    private String date;
    private String status;
    private String priority;

    public static NoteDetailFragment newInstance(String title, String description, String date, String status, String priority) {
        NoteDetailFragment fragment = new NoteDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_DATE, date);
        args.putString(ARG_STATUS, status);
        args.putString(ARG_PRIORITY, priority);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
            date = getArguments().getString(ARG_DATE);
            status = getArguments().getString(ARG_STATUS);
            priority = getArguments().getString(ARG_PRIORITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_note_detail, container, false);

        // Bind data to UI elements
        TextView titleTextView = view.findViewById(R.id.noteTitleTextView);
        TextView descriptionTextView = view.findViewById(R.id.noteDescriptionTextView);
        ImageButton backPress_arrow = view.findViewById(R.id.backPress_arrow);
        TextView dateTextView = view.findViewById(R.id.dateTextView);
        TextView status_bar = view.findViewById(R.id.status_bar);
        TextView priority_bar = view.findViewById(R.id.priority_bar);

        //diabling below line in edittext
        titleTextView.setBackground(null);


        //back press arrow functionality
        backPress_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBackPree();
            }
        });

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        dateTextView.setText(date);
        status_bar.setText(status);
        priority_bar.setText(priority);


        return view;
    }

    public void handleBackPree() {
        if(getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}