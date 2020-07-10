package com.example.otrstattelecom.model.request;

public class RequestQueueEdit {
    String Owner;
    String Queue;

    public RequestQueueEdit(String owner, String queue) {
        Owner = owner;
        Queue = queue;
    }


    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getQueue() {
        return Queue;
    }

    public void setQueue(String queue) {
        Queue = queue;
    }
}
