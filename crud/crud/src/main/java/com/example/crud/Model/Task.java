package com.example.crud.Model;

import jakarta.annotation.Generated;

public class Task {

    private int id;
    private String Task;
    private  boolean isComplete;
    private boolean isEditing;

    public Task() {
    }

    public Task(int id, String task, boolean isComplete, boolean isEditing) {
        this.id = id;
        Task = task;
        this.isComplete = isComplete;
        this.isEditing = isEditing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Task='" + Task + '\'' +
                ", isComplete=" + isComplete +
                ", isEditing=" + isEditing +
                '}';
    }
}
