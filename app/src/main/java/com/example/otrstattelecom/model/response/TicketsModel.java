package com.example.otrstattelecom.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketsModel {
    @SerializedName("Ticket")
    @Expose
    List<Ticket> ticket;

    @SerializedName("Error")
    @Expose
    Error error;

    public TicketsModel(List<Ticket> ticket, Error error) {
        this.ticket = ticket;
        this.error = error;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
