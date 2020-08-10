package com.example.otrstattelecom.model.response;

import com.example.otrstattelecom.model.dto.History;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketHistoryModel {
    @SerializedName("History")
    List<History> historyList;

    public TicketHistoryModel(List<History> historyList) {
        this.historyList = historyList;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }
}
