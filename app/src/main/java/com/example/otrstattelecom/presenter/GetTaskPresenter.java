package com.example.otrstattelecom.presenter;

import android.widget.Toast;

import com.example.otrstattelecom.model.ErrorResponse;
import com.example.otrstattelecom.model.LoginModelPref;
import com.example.otrstattelecom.model.MessageDTO;
import com.example.otrstattelecom.model.RequestCloseTicketModel;
import com.example.otrstattelecom.model.RequestData;
import com.example.otrstattelecom.model.RequestLock;
import com.example.otrstattelecom.model.RequestLockTicketModel;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.RequestState;
import com.example.otrstattelecom.model.TicketsModel;
import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.model.api.ApiFactory;
import com.example.otrstattelecom.model.api.ApiInterface;
import com.example.otrstattelecom.utils.ErrorUtils;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.utils.URLS;
import com.example.otrstattelecom.view.GetTasksView;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
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

    public void autH(String login, String password){
     Call<Token> call =  apiInterface.requestLogin(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword());

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if (response.isSuccessful()) {
                    pref.setUserLogin(response.body().getSessionID(), pref.getUserId(), login, password);
                    taskView.onTaskFailed("auth ok");
                    taskView.onTaskFailed(pref.getToken().getSessionID());
                } else {
                    taskView.onTaskFailed("error auth");
                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                taskView.onTaskFailed("error auth exp");
            }
        });

    }

    public void getTickets(String session) {

        Call<TicketIDs> call = apiInterface.getTicketIDs(session, "%%");

        call.enqueue(new Callback<TicketIDs>() {
            @Override
            public void onResponse(Call<TicketIDs> call, Response<TicketIDs> response) {

                if(response.isSuccessful() && response.body().getList() != null)
                    getTasks(response.body().getList(), session);
                else {
                    try {
                        //JSONObject jObjError = new JSONObject(response.message());
                        if(response.body().getErrorStatus().getStatus().equals("TicketSearch.AuthFail"))
                            taskView.onTaskFailed("auth");
                            autH(pref.authenticationUser().getLogin(), pref.authenticationUser().getPassword());
                            //LoginModelPref loginModelPref = pref.authenticationUser();
                    } catch (Exception e) {
                        taskView.onTaskFailed(e.getMessage());
                    }

                }

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

    public void closeTask(String session, String idTicket){
        Call<MessageDTO> call = apiInterface.closeTask(new RequestCloseTicketModel(session, idTicket, new RequestState("closed successful")));
        call.enqueue(new Callback<MessageDTO>() {
            @Override
            public void onResponse(Call<MessageDTO> call, Response<MessageDTO> response) {
                getTickets(session);
            }

            @Override
            public void onFailure(Call<MessageDTO> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }

    public void lockTask(String session, String idTicket, String lock){
        if(lock.equals("lock"))
            lock = "unlock";
        else
            lock = "lock";
        Call<MessageDTO> call = apiInterface.lockTask(new RequestLockTicketModel(session, idTicket, new RequestLock(lock)));
        call.enqueue(new Callback<MessageDTO>() {
            @Override
            public void onResponse(Call<MessageDTO> call, Response<MessageDTO> response) {
                getTickets(session);
            }

            @Override
            public void onFailure(Call<MessageDTO> call, Throwable t) {
                taskView.onTaskFailed(t.getMessage().toString());
            }
        });
    }



}
