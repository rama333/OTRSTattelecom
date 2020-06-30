package com.example.otrstattelecom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorStatus {

    @SerializedName("ErrorCode")
    @Expose
    String status;

    public ErrorStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
