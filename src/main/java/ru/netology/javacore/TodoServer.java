package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    String taskLine = in.readLine();

                    TodoRequest todoRequest = gson.fromJson(taskLine, TodoRequest.class);

                    if (todoRequest != null) {
                        switch (todoRequest.getType()) {
                            case ADD -> todos.addTask(todoRequest.getTask());
                            case REMOVE -> todos.removeTask(todoRequest.getTask());
                        }
                    }

                    out.println("Ваши задачи: " + todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать");
            e.printStackTrace();
        }
    }
}
