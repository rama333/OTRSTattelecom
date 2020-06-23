package com.example.otrstattelecom.presenter;

import com.example.otrstattelecom.model.Request;
import com.example.otrstattelecom.model.RequestData;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.TicketsModel;
import com.example.otrstattelecom.model.api.ApiFactory;
import com.example.otrstattelecom.model.api.ApiInterface;
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

    private List<TicketIDs> dataModels = new ArrayList<>();

    public GetTaskPresenter(GetTasksView taskView) {
        this.taskView = taskView;
    }

    public void getTickets(String session) {

        Call<TicketIDs> call = apiInterface.getTicketIDs(session, "%%");


        call.enqueue(new Callback<TicketIDs>() {
            @Override
            public void onResponse(Call<TicketIDs> call, Response<TicketIDs> response) {

                if(response.code() == 200 && response.body().getList() != null)
                    getTasks(response.body().getList(), session);
                else
                    taskView.onTaskFailed("error");
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



}
