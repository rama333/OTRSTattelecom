package com.example.otrstattelecom.model.request;

public class RequestQueueEdit {
    String Queue;


    public RequestQueueEdit(String queue) {
        Queue = queue;
    }

    public String getQueue() {
        return Queue;
    }

    public void setQueue(String queue) {
        Queue = queue;
    }
}
