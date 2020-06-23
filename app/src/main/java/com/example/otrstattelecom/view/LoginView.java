package com.example.otrstattelecom.view;


import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.model.UserModel;

public interface LoginView {
    void onLoginSuccess(Token token);
    void onLoginFailed(String error);
}
