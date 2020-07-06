package com.example.otrstattelecom.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Token implements Serializable {

    @SerializedName("Error")
    @Expose
    Error error;
    @SerializedName("SessionID")
    @Expose
    String SessionID;


    public Token(Error error, String sessionID) {
        this.error = error;
        SessionID = sessionID;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }
}
