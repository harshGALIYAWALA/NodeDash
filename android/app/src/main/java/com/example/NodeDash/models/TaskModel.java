package com.example.NodeDash.models;

import java.util.Date;

public class TaskModel {

    String id;
     String title;
     String description;
     String status;
    String dueDate;
     String priority;
    String createdAt;
    String updatedAt;
     String userId;

    // Constructor with only title and description
    public TaskModel(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "pending"; // Default status
        this.priority = "low";   // Default priority
        this.userId = "60ff47b2c11f1b001c8c5e5d"; // Replace with your default userId
    }

    // Constructor for updating a task with ID
    public TaskModel(String id, String title, String description) {
        this.id = id;               // Set the ID for the existing task
        this.title = title;
        this.description = description;
    }


    // Constructor for 5 parameters (Fragment usage)
    public TaskModel(String title, String description, String status, String dueDate, String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Constructor for 8 parameters (Backend mapping)
    public TaskModel(String title, String description, String status, String dueDate, String priority, String createdAt, String updatedAt, String userId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
