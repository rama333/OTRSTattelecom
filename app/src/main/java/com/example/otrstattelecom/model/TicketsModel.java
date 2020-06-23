package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TicketsModel {
    @SerializedName("Ticket")
    List<Ticket> ticket;

    public TicketsModel(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }


}
