package com.example.otrstattelecom.view;


public interface LoginView {
    void onLoginSuccess(String session, String userId, String login, String password);
    void onLoginFailed(String error);
}
