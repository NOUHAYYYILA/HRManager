package com.example.demo.dao.entities;


public class Task {
    private String description;

    // Constructeur par défaut
    public Task() {}

    // Constructeur avec paramètres
    public Task(String description) {
        this.description = description;
    }

    // Getter pour description
    public String getDescription() {
        return description;
    }

    // Setter pour description
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}



