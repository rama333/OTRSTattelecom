package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestDataHistory {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    String TicketID;


    public RequestDataHistory(String sessionID, String ticketID) {
        SessionID = sessionID;
        TicketID = ticketID;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }
}
