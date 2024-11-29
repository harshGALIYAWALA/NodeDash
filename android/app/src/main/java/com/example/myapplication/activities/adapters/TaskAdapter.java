package com.example.myapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import models.TaskModel;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    Context context;
    ArrayList<TaskModel> arrayTaskModel;

    public TaskAdapter(Context context, ArrayList<TaskModel> arrayTaskModel) {
        this.context = context;
        this.arrayTaskModel = arrayTaskModel;
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_layout, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskModel taskModel = arrayTaskModel.get(position);
        holder.title.setText(taskModel.getTitle());
        holder.description.setText(taskModel.getDescription());
        holder.status.setText(taskModel.getStatus());
        holder.priority.setText(taskModel.getPriority());
        holder.dueDate.setText(taskModel.getDueDate());
    }

    @Override
    public int getItemCount() {
        return arrayTaskModel.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        TextView title, description, status, priority, dueDate;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_title);
            description = itemView.findViewById(R.id.task_description);
            status = itemView.findViewById(R.id.task_status);
            priority = itemView.findViewById(R.id.task_priority);
            dueDate = itemView.findViewById(R.id.task_dueDate);
        }
    }

}
