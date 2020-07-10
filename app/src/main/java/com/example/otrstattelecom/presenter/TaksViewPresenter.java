package com.example.otrstattelecom.presenter;

import android.net.Uri;

import com.example.otrstattelecom.model.dto.ArticleMessage;
import com.example.otrstattelecom.model.response.Message;
import com.example.otrstattelecom.model.request.MessageModelRequest;
import com.example.otrstattelecom.model.request.RequestData;
import com.example.otrstattelecom.model.response.TicketIDs;
import com.example.otrstattelecom.model.response.TicketsModel;
import com.example.otrstattelecom.model.api.ApiFactory;
import com.example.otrstattelecom.model.api.ApiInterface;
import com.example.otrstattelecom.model.response.Token;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.utils.URLS;
import com.example.otrstattelecom.view.TaskView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaksViewPresenter {
    ApiInterface apiInterface = ApiFactory.getRetrofitInstance(URLS.getUrlRoot()).create(ApiInterface.class);

    TaskView taskView;
    Pref pref;

    private List<TicketIDs> dataModels = new ArrayList<>();

    public TaksViewPresenter(TaskView taskView, Pref pref) {
        this.taskView = taskView;
        this.pref = pref;
    }

    public void autH(String login, String password, List<String> list){
        Call<Token> call =  apiInterface.requestLogin(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword());

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if (response.isSuccessful() && response.body().getError() == null) {
                    pref.setUserLogin(response.body().getSessionID(), pref.getUserId(), login, password);
                    taskView.onTaskFailed("auth ok");
                    taskView.onTaskFailed(pref.getToken());

                    getTasks(list, response.body().getSessionID());

                } else {
                    taskView.onTaskFailed("Ошибка auth");
                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                taskView.onTaskFailed("Ошибка auth");
            }
        });

    }

    public void getTasks(List<String> list, String session) {

        Call<TicketsModel> call = apiInterface.getTickets(new RequestData(session, list));


        call.enqueue(new Callback<TicketsModel>() {
            @Override
            public void onResponse(Call<TicketsModel> call, Response<TicketsModel> response) {

                if(response.isSuccessful() && response.body().getError() != null)
                    autH(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword(), list);

                if(response.isSuccessful() && response.body().getTicket() != null)
                    taskView.onTaskSuccess(response.body().getTicket());
            }

            @Override
            public void onFailure(Call<TicketsModel> call, Throwable t) {
                taskView.onTaskFailed("Не удалось связаться с сервером");
            }
        });
    }

    public void setMessage(String message, String idTicket, String session){
        Call<Message> call = apiInterface.setMessage(new MessageModelRequest(session, idTicket,  new ArticleMessage(message,"utf8","testbn","text/plain", "0")));

        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                getTasks(new ArrayList<String>(Arrays.asList(response.body().getTicketID())), session);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }





}
