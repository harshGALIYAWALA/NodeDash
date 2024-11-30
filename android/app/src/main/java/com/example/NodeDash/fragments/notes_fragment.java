package com.example.NodeDash.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.NodeDash.R;
import com.example.NodeDash.adapters.TaskAdapter;

import java.util.ArrayList;

import com.example.NodeDash.models.TaskModel;
import com.example.NodeDash.screens.OpenNoteActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link notes_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class notes_fragment extends Fragment {

        RecyclerView recyclerView;
        ArrayList<TaskModel> taskModels = new ArrayList<>();
        TaskAdapter adapter;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public notes_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notes_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static notes_fragment newInstance(String param1, String param2) {
        notes_fragment fragment = new notes_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        taskModels.add(new TaskModel("Task 1", "Description for Task 1", "Pending", "2024-12-01", "Low"));
        taskModels.add(new TaskModel("Task 2", "Description for Task 2", "In Progress", "2024-12-02", "High"));
        



        // Initialize adapter with click listener
        adapter = new TaskAdapter(getContext(), taskModels, new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TaskModel taskModel) {
                // Open open_note_activity with the clicked item's details
                Intent intent = new Intent(getContext(), OpenNoteActivity.class);
                intent.putExtra("title", taskModel.getTitle());
                intent.putExtra("description", taskModel.getDescription());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}