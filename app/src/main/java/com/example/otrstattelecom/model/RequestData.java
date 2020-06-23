package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestData {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    List<String> TicketID;
    @SerializedName("AllArticles")
    String AllArticles="1";

    public RequestData(String sessionID, List<String> ticketID) {
        SessionID = sessionID;
        TicketID = ticketID;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public List<String> getTicketID() {
        return TicketID;
    }

    public void setTicketID(List<String> ticketID) {
        TicketID = ticketID;
    }
}
