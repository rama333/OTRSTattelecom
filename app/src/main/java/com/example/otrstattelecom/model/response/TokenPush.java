package com.example.otrstattelecom.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenPush {
    @SerializedName("state")
    @Expose
    String state;
    @SerializedName("token")
    @Expose
    String token;

    public TokenPush(String state, String token) {
        this.state = state;
        this.token = token;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
