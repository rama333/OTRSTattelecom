package com.example.otrstattelecom.presenter;

import com.example.otrstattelecom.model.Request;
import com.example.otrstattelecom.model.RequestData;
import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.model.UserModel;
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

    private List<UserModel> dataModels = new ArrayList<>();

    public LoginPresenter(LoginActivity coinView) {
        this.loginView = coinView;
    }

    public void login(String username, String password) {

        Call<Token> call = apiInterface.requestLogin(username, password);

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if(response.code() == 200)
                    loginView.onLoginSuccess(response.body());
                else
                    loginView.onLoginFailed("error data");
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                loginView.onLoginFailed("error");
            }
        });

    }
}
