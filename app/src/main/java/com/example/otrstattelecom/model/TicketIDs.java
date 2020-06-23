package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TicketIDs implements Serializable {

    @SerializedName("TicketID")
    List<String> list;

    public TicketIDs(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
