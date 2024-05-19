package com.example.demo.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "marketer")
public class Marketer extends Employee {
    // Attributs spécifiques d'un marketeur
    private String marketingStrategy;

    // Constructeur
    public Marketer() {
        super();
    }

    // Getters et Setters pour l'attribut spécifique
    public String getMarketingStrategy() {
        return marketingStrategy;
    }

    public void setMarketingStrategy(String marketingStrategy) {
        this.marketingStrategy = marketingStrategy;
    }
}
