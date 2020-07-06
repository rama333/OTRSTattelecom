package com.example.otrstattelecom.presenter;

import com.example.otrstattelecom.model.response.Message;
import com.example.otrstattelecom.model.request.RequestCloseTicketModel;
import com.example.otrstattelecom.model.request.RequestData;
import com.example.otrstattelecom.model.request.RequestLock;
import com.example.otrstattelecom.model.request.RequestLockTicketModel;
import com.example.otrstattelecom.model.request.RequestTicketIds;
import com.example.otrstattelecom.model.response.TicketIDs;
import com.example.otrstattelecom.model.request.RequestState;
import com.example.otrstattelecom.model.response.TicketsModel;
import com.example.otrstattelecom.model.response.Token;
import com.example.otrstattelecom.model.api.ApiFactory;
import com.example.otrstattelecom.model.api.ApiInterface;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.utils.URLS;
import com.example.otrstattelecom.view.GetTasksView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetTaskPresenter {
    ApiInterface apiInterface = ApiFactory.getRetrofitInstance(URLS.getUrlRoot()).create(ApiInterface.class);
    GetTasksView taskView;
    Pref pref;

    private List<TicketIDs> dataModels = new ArrayList<>();

    public GetTaskPresenter(GetTasksView taskView, Pref pref) {
        this.taskView = taskView;
        this.pref = pref;
    }

    public void autH(String login, String password, List<String> stateType){
     Call<Token> call =  apiInterface.requestLogin(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword());

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if (response.isSuccessful() && response.body().getError() == null) {
                    pref.setUserLogin(response.body().getSessionID(), pref.getUserId(), login, password);
                    taskView.onTaskFailed("auth ok");
                    taskView.onTaskFailed(pref.getToken());

                    getTickets(response.body().getSessionID(), stateType);

                } else {
                    taskView.onTaskFailed("error auth");
                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                taskView.onTaskFailed("Ошибка auth");
            }
        });

    }

    public void getTickets(String session, List<String> stateType) {

        Call<TicketIDs> call = apiInterface.getTicketIDs(new RequestTicketIds(session, "%%" , stateType));

        call.enqueue(new Callback<TicketIDs>() {
            @Override
            public void onResponse(Call<TicketIDs> call, Response<TicketIDs> response) {

                if(response.body().getErrorStatus() != null && response.body().getErrorStatus().getStatus().equals("TicketSearch.AuthFail")) {
                    taskView.onTaskFailed("auth");
                    autH(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword(), stateType);
                }

                if(response.isSuccessful() && response.body().getList() != null)
                    getTasks(response.body().getList(), session);
                else if (response.body().getErrorStatus() == null)
                    taskView.onTaskFailed("Отсутсвуют таски");

            }

            @Override
            public void onFailure(Call<TicketIDs> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }

    public void getTasks(List<String> list, String session) {

        Call<TicketsModel> call = apiInterface.getTickets(new RequestData(session, list));


        call.enqueue(new Callback<TicketsModel>() {
            @Override
            public void onResponse(Call<TicketsModel> call, Response<TicketsModel> response) {

                if(response.code() == 200 && response.body().getTicket() != null)
                    taskView.onTaskSuccess(response.body().getTicket());
            }

            @Override
            public void onFailure(Call<TicketsModel> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }

    public void closeTask(String session, String idTicket, List<String> stateType){
        Call<Message> call = apiInterface.closeTask(new RequestCloseTicketModel(session, idTicket, new RequestState("closed successful")));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                getTickets(session, stateType);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }

    public void lockTask(String session, String idTicket, String lock, List<String> stateType){
        if(lock.equals("lock"))
            lock = "unlock";
        else
            lock = "lock";
        Call<Message> call = apiInterface.lockTask(new RequestLockTicketModel(session, idTicket, new RequestLock(lock, pref.authenticationUser().getLogin())));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                getTickets(session, stateType);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }
}
