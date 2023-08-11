/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Task;

import Models.List;
import java.util.ArrayList;

public class TaskList implements List<Task> {
    private static TaskList taskList;
    private ArrayList<Task> tasks;

    private TaskList() {
        this.tasks = new ArrayList<>();
    }

    public static TaskList getInstance() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

    @Override
    public boolean insert(Task obj) {
        return tasks.add(obj);
    }

    @Override
    public boolean update(Task obj) {
        int index = tasks.indexOf(obj);
        if (index != -1) {
            tasks.set(index, obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Task obj) {
        return tasks.remove(obj);
    }

    @Override
    public Task search(Object id) {
        for (Task task : tasks) {
            if (task.getName().equals(id)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Task[] toArray() {
        return tasks.toArray(new Task[0]);
    }
}