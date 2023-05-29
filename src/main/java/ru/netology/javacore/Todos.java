package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todos {
    private String type;
    private String task;
    private final List<String> tasks = new ArrayList<>();

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void addTask(String task) {
        if (tasks.size() < 7) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);

        return String.join(" ", tasks);
    }

}
