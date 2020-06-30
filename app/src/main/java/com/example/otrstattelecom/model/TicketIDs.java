package com.example.otrstattelecom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TicketIDs implements Serializable {


    @SerializedName("TicketID")
    @Expose
    List<String> list;
    @SerializedName("Error")
    @Expose
    ErrorStatus errorStatus;

    public TicketIDs(List<String> list, ErrorStatus errorStatus) {
        this.list = list;
        this.errorStatus = errorStatus;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
