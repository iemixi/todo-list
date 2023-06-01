package ru.netology.javacore;

import java.util.*;

public class Todos {
    private final Set<String> tasks = new TreeSet<>();

    public void addTask(String task) {
        if (tasks.size() < 7) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return String.join(" ", tasks);
    }

}
