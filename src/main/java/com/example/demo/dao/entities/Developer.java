package com.example.demo.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer")
public class Developer extends Employee {
    // Attributs spécifiques d'un développeur
    private String programmingLanguage;

    // Constructeur
    public Developer() {
        super();
    }

    // Getters et Setters pour l'attribut spécifique
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
