package com.example.otrstattelecom.view;

import com.example.otrstattelecom.model.response.Ticket;

import java.util.List;

public interface GetTasksView {

    void onTaskSuccess(List<Ticket> tickets);
    void onTaskFailed(String error);
}
