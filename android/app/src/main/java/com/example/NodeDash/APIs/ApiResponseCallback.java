package com.example.NodeDash.APIs;

public interface ApiResponseCallback {
    void onSuccess(Object response);
    void onError(String error);
}
