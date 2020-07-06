package com.example.otrstattelecom.view;

import com.example.otrstattelecom.model.response.Ticket;

import java.util.List;

public interface TaskView {
    void onTaskSuccess(List<Ticket> tickets);
    void onTaskFailed(String error);
}
