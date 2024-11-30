package com.example.NodeDash.APIs;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;

import com.example.NodeDash.models.TaskModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {

    private static final String BASE_URL = "http://10.0.2.2:5000/api/task";

    private OkHttpClient client;
    private Gson gson;

    public ApiClient(){
        client = new OkHttpClient();
        gson = new Gson();
    }

    // Fetch tasks (GET request)
    public void getTask(final ApiResponseCallback callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "task")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    TaskModel[] tasks = gson.fromJson(response.body().string(), TaskModel[].class);
                }
                else {
                    callback.onError(response.message());
                }
            }
        });
    }

    // Create a task (POST request)
    public void createTask(TaskModel taskModel ,final ApiResponseCallback callback) {
        String json = gson.toJson(taskModel);
        Request request = new Request.Builder()
                .url(BASE_URL + "task")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    TaskModel createdTask = gson.fromJson(response.body().string(), TaskModel.class);
                } else {
                    callback.onError(response.message());
                }
            }
        });
    }



}
