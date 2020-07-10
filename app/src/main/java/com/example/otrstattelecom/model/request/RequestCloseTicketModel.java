package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

public class RequestCloseTicketModel {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    String  TicketID;
    @SerializedName("Ticket")
    RequestQueueEdit requestQueueEdit;
    @SerializedName("DynamicField")
    DynamicField dynamicField;

    public RequestCloseTicketModel(String sessionID, String ticketID, RequestQueueEdit requestQueueEdit, DynamicField dynamicField) {
        SessionID = sessionID;
        TicketID = ticketID;
        this.requestQueueEdit = requestQueueEdit;
        this.dynamicField = dynamicField;
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

    public RequestQueueEdit getRequestQueueEdit() {
        return requestQueueEdit;
    }

    public void setRequestQueueEdit(RequestQueueEdit requestQueueEdit) {
        this.requestQueueEdit = requestQueueEdit;
    }

    public DynamicField getDynamicField() {
        return dynamicField;
    }

    public void setDynamicField(DynamicField dynamicField) {
        this.dynamicField = dynamicField;
    }
}
