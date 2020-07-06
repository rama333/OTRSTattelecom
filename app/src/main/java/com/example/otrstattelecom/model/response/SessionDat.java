package com.example.otrstattelecom.model.response;

public class SessionDat {
    String Value;
    String Key;

    public SessionDat(String value, String key) {
        Value = value;
        Key = key;
    }


    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
