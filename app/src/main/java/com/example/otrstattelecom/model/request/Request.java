package com.example.otrstattelecom.model.request;

import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("Data")
    RequestData data;

    public Request(RequestData data) {
        this.data = data;
    }

    public RequestData getData() {
        return data;
    }

    public void setData(RequestData data) {
        this.data = data;
    }
}
