package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestTicketIds {


    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketNumber")
    String TicketNumber;
    @SerializedName("States")
    List<String> StateType;


    public RequestTicketIds(String sessionID, String ticketNumber, List<String> stateType) {
        SessionID = sessionID;
        TicketNumber = ticketNumber;
        StateType = stateType;
    }


    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        TicketNumber = ticketNumber;
    }

    public List<String> getStateType() {
        return StateType;
    }

    public void setStateType(List<String> stateType) {
        StateType = stateType;
    }
}
