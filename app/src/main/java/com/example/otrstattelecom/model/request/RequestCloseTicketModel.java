package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestCloseTicketModel {
    @SerializedName("SessionID")
    String SessionID;
    @SerializedName("TicketID")
    String  TicketID;
    @SerializedName("Ticket")
    RequestQueueEdit requestQueueEdit;
    @SerializedName("DynamicField")
    List<DynamicField> dynamicField;

    public RequestCloseTicketModel(String sessionID, String ticketID, RequestQueueEdit requestQueueEdit, List<DynamicField> dynamicField) {
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

    public List<DynamicField> getDynamicField() {
        return dynamicField;
    }

    public void setDynamicField(List<DynamicField> dynamicField) {
        this.dynamicField = dynamicField;
    }
}
