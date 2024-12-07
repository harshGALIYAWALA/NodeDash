package com.example.NodeDash.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.NodeDash.APIs.ApiClient;
import com.example.NodeDash.APIs.ApiResponseCallback;
import com.example.NodeDash.R;
import com.example.NodeDash.adapters.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.NodeDash.models.TaskModel;
import com.example.NodeDash.screens.OpenNoteActivity;

public class notes_fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<TaskModel> taskModels;
    TaskAdapter adapter;

    public notes_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Initialize the list and adapter
        taskModels = new ArrayList<>();
        adapter = new TaskAdapter(getContext(), taskModels, new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TaskModel taskModel) {
                Intent intent = new Intent(getContext(), OpenNoteActivity.class);
                intent.putExtra("title", taskModel.getTitle());
                intent.putExtra("description", taskModel.getDescription());
                intent.putExtra("status", taskModel.getStatus());
                intent.putExtra("dueDate", taskModel.getDueDate());
                intent.putExtra("priority", taskModel.getPriority());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        fetchUpdatedTasks(); // Initial fetch when fragment is created
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchUpdatedTasks(); // Fetch the latest tasks when returning to the fragment
    }

    private void fetchUpdatedTasks() {
        new ApiClient().getTask(new ApiResponseCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response instanceof List) {
                    List<TaskModel> updatedTasks = (List<TaskModel>) response;

                    // Update the RecyclerView
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(() -> {
                            taskModels.clear(); // Clear the existing list
                            taskModels.addAll(updatedTasks); // Add new tasks
                            adapter.notifyDataSetChanged(); // Refresh RecyclerView
                        });
                    }
                }
            }

            @Override
            public void onError(String error) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Error fetching tasks: " + error, Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}
