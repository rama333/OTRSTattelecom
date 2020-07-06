package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

public class RequestCloseTicketModel {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    String  TicketID;
    @SerializedName("Ticket")
    RequestState requestState;

    public RequestCloseTicketModel(String sessionID, String ticketID, RequestState requestState) {
        SessionID = sessionID;
        TicketID = ticketID;
        this.requestState = requestState;
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

    public RequestState getRequestState() {
        return requestState;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }
}
