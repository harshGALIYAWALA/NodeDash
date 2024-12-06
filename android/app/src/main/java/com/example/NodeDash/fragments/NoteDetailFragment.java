package com.example.NodeDash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.NodeDash.APIs.ApiClient;
import com.example.NodeDash.APIs.ApiResponseCallback;
import com.example.NodeDash.R;
import com.example.NodeDash.models.TaskModel;

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
        Button saveBtn = view.findViewById(R.id.saveBtn);

        //diabling below line in edittext
        titleTextView.setBackground(null);


        //back press arrow functionality
        backPress_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBackPree();
            }
        });

        // Set initial values (if any)
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        dateTextView.setText(date);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = titleTextView.getText().toString();
                String description = descriptionTextView.getText().toString();
                String date = dateTextView.getText().toString();
                String status = status_bar.getText().toString();
                String priority = priority_bar.getText().toString();

                if(title.isEmpty()){
                    titleTextView.setError("enter title!");
                    return;
                }

                // Create the note using API
                TaskModel taskModel = new TaskModel(title, description, date, status, priority);
                new ApiClient().createTask(taskModel, new ApiResponseCallback() {
                    @Override
                    public void onSuccess(Object response) {
                        // Ensure the Toast is displayed on the main thread (UI thread)
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(() -> {
                                Log.d("API", "Data saved successfully: " + response);
                                Toast.makeText(getContext(), "Note Created", Toast.LENGTH_SHORT).show();
                                // Close the activity after saving
                                getActivity().finish();
                            });
                        }
                    }

                    @Override
                    public void onError(String error) {
                        // Ensure the Toast is displayed on the main thread (UI thread)
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(() -> {
                                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
                            });
                        }
                    }
                });

            }
        });

        return view;
    }

    public void handleBackPree() {
        if(getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}