package com.example.rxjava;

public class DataModel {
    String task;
    boolean status;
    int priority;

    public DataModel(String task, boolean status, int priority) {
        this.task = task;
        this.status = status;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public boolean isStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }
}
