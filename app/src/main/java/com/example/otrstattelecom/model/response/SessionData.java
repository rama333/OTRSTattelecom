package com.example.otrstattelecom.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SessionData {
    @SerializedName("SessionData")
    List<SessionDat> session;

    public SessionData(List<SessionDat> session) {
        this.session = session;
    }

    public List<SessionDat> getSession() {
        return session;
    }

    public void setSession(List<SessionDat> session) {
        this.session = session;
    }
}
