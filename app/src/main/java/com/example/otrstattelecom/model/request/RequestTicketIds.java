package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestTicketIds {

    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketNumber")
    String TicketNumber;
    @SerializedName("States")
    List<String> StateType;
    @SerializedName("OwnerIDs")
    String OwnerIDs;

    public RequestTicketIds(String sessionID, String ticketNumber, List<String> stateType, String ownerIDs) {
        SessionID = sessionID;
        TicketNumber = ticketNumber;
        StateType = stateType;
        OwnerIDs = ownerIDs;
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

    public String getOwnerIDs() {
        return OwnerIDs;
    }

    public void setOwnerIDs(String ownerIDs) {
        OwnerIDs = ownerIDs;
    }
}
