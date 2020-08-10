package com.example.otrstattelecom.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketHistory {
    @SerializedName("TicketHistory")
    List<TicketHistoryModel> ticketHistoryModel;

    public TicketHistory(List<TicketHistoryModel> ticketHistoryModel) {
        this.ticketHistoryModel = ticketHistoryModel;
    }

    public List<TicketHistoryModel> getTicketHistoryModel() {
        return ticketHistoryModel;
    }

    public void setTicketHistoryModel(List<TicketHistoryModel> ticketHistoryModel) {
        this.ticketHistoryModel = ticketHistoryModel;
    }
}
