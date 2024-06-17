package com.example.todolistapp.model;

public class Todo {
    private String description;

    // Constructors, getters, and setters
    public Todo() {}

    public Todo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
