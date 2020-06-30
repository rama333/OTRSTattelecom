package com.example.otrstattelecom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("ErrorCode")
    @Expose
    ErrorStatus status;

    public ErrorResponse(ErrorStatus status) {
        this.status = status;
    }

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}
