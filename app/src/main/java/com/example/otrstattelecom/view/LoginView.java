package com.example.otrstattelecom.view;


import com.example.otrstattelecom.model.SessionData;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.model.UserModel;

public interface LoginView {
    void onLoginSuccess(String session, String userId, String login, String password);
    void onLoginFailed(String error);
}
