package ru.netology.javacore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {
    @Test
    void testAddTask() {
        String expected = "task1 task2 task3 task4 task5 task6 task7";

        Todos todos = new Todos();

        todos.addTask("task1");
        todos.addTask("task2");
        todos.addTask("task3");
        todos.addTask("task4");
        todos.addTask("task5");
        todos.addTask("task6");
        todos.addTask("task7");
        todos.addTask("task8");

        String actual = todos.getAllTasks();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveTask() {
        String expected = "task2";

        Todos todos = new Todos();

        todos.addTask("task1");
        todos.addTask("task2");

        todos.removeTask("task1");

        String actual = todos.getAllTasks();

        assertEquals(expected, actual);
    }

    @Test
    void testGetAllTasks() {
        String expected = "task1 task2";

        Todos todos = new Todos();

        todos.addTask("task2");
        todos.addTask("task1");

        String actual = todos.getAllTasks();

        assertEquals(expected, actual);
    }
}
