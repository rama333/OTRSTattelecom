package com.example.otrstattelecom.model;

public class RequestLock {
    String Lock;

    public RequestLock(String lock) {
        Lock = lock;
    }

    public String getLock() {
        return Lock;
    }

    public void setLock(String lock) {
        Lock = lock;
    }
}
