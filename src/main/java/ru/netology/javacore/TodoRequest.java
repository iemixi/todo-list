package ru.netology.javacore;

public class TodoRequest {
    private RequestType type;
    private String task;

    public TodoRequest(RequestType type, String task) {
        this.type = type;
        this.task = task;
    }

    public TodoRequest() {
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
