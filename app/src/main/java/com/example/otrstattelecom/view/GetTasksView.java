package com.example.otrstattelecom.view;

import com.example.otrstattelecom.model.Ticket;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.TicketsModel;

import java.util.ArrayList;
import java.util.List;

public interface GetTasksView {

    void onTaskSuccess(List<Ticket> tickets);
    void onTaskFailed(String error);
}
