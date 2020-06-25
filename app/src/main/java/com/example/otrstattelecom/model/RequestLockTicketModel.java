package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

public class RequestLockTicketModel {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    String  TicketID;
    @SerializedName("Ticket")
    RequestLock requestLock;

    public RequestLockTicketModel(String sessionID, String ticketID, RequestLock requestLock) {
        SessionID = sessionID;
        TicketID = ticketID;
        this.requestLock = requestLock;
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

    public RequestLock getRequestLock() {
        return requestLock;
    }

    public void setRequestLock(RequestLock requestLock) {
        this.requestLock = requestLock;
    }
}
