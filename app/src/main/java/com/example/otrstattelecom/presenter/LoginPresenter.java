package com.example.otrstattelecom.presenter;

import com.example.otrstattelecom.model.response.SessionData;
import com.example.otrstattelecom.model.response.Token;
import com.example.otrstattelecom.model.api.ApiFactory;
import com.example.otrstattelecom.model.api.ApiInterface;
import com.example.otrstattelecom.utils.URLS;
import com.example.otrstattelecom.view.LoginActivity;
import com.example.otrstattelecom.view.LoginView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    ApiInterface apiInterface = ApiFactory.getRetrofitInstance(URLS.getUrlRoot()).create(ApiInterface.class);
    LoginView loginView;


    public LoginPresenter(LoginActivity coinView) {
        this.loginView = coinView;
    }

    public void login(String username, String password) {

        Call<Token> call = apiInterface.requestLogin(username, password);

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if(response.isSuccessful() && response.body().getSessionID() != null)
                    getIdUser(response.body().getSessionID(), username, password);

                if(response.isSuccessful() && response.body().getError() != null)
                    loginView.onLoginFailed("Неправильный логин или пароль");
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                loginView.onLoginFailed("Ошибка: не удалось связаться с сервером");
            }
        });
    }

    public void getIdUser(String session, String login, String password) {

        Call<SessionData> call = apiInterface.getUserId(session);

        call.enqueue(new Callback<SessionData>() {
            @Override
            public void onResponse(Call<SessionData> call, Response<SessionData> response) {
                String userID="";

                if(response.isSuccessful() && response.body().getSession() != null) {
                    for (int i = 0; i < response.body().getSession().size(); i++) {
                        if (response.body().getSession().get(i).getKey().equals("UserID")) {
                            userID = response.body().getSession().get(i).getValue();
                            break;
                        }
                    }
                    loginView.onLoginSuccess(session, userID, login, password);
                }
                else
                    loginView.onLoginFailed("Ошибка");
            }

            @Override
            public void onFailure(Call<SessionData> call, Throwable t) {
                loginView.onLoginFailed("Ошибка: не удалось связаться с сервером");
            }
        });
    }
}
