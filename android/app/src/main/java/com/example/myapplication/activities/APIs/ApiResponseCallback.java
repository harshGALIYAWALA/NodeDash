package com.example.myapplication.activities.APIs;

public interface ApiResponseCallback {
    void onSuccess(Object response);
    void onError(String error);
}
