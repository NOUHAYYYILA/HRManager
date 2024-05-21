package com.example.demo.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developer")
public class Developer extends Employee {
    // Attributs spécifiques d'un développeur
    private String programmingLanguage;


}
