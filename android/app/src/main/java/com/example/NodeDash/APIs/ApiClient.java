package com.example.NodeDash.APIs;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.example.NodeDash.models.TaskModel;
import com.google.gson.reflect.TypeToken;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiClient {

    private static final String BASE_URL = "http://10.0.2.2:5000/api/";

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
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    Type listType = new TypeToken<List<TaskModel>>() {}.getType();
                    List<TaskModel> tasks = gson.fromJson(responseBody, listType);
                    callback.onSuccess(tasks);
                } else {
                    callback.onError(response.message());
                }
            }
        });
    }

    // Create a task (POST request)
    public void createTask(TaskModel taskModel, final ApiResponseCallback callback) {
        String json = gson.toJson(taskModel); // Convert TaskModel to JSON
        RequestBody body = RequestBody.create(json, okhttp3.MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(BASE_URL + "task")
                .post(body) // Specify POST method with RequestBody
                .addHeader("Content-Type", "application/json") // Explicitly add Content-Type
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError(e.getMessage()); // Handle failure
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    TaskModel createdTask = gson.fromJson(response.body().string(), TaskModel.class);
                    callback.onSuccess(createdTask); // Pass success response
                } else {
                    callback.onError(response.message()); // Handle error
                }
            }
        });
    }


    public void updateTask(String taskId, TaskModel taskModel, final ApiResponseCallback callback) {
        String json = gson.toJson(taskModel); // Convert the taskModel to JSON
        RequestBody body = RequestBody.create(json, okhttp3.MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "task/" + taskId) // Append task ID for update
                .put(body) // PUT request
                .addHeader("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().string());
                } else {
                    callback.onError(response.message());
                }
            }
        });
    }




}
