package com.example.otrstattelecom.model;

public class RequestLock {
    String Lock;
    String Owner;

    public RequestLock(String lock, String owner) {
        Lock = lock;
        Owner = owner;
    }

    public String getLock() {
        return Lock;
    }

    public void setLock(String lock) {
        Lock = lock;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
}
