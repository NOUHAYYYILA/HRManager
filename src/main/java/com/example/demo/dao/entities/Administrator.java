package com.example.demo.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "administrator")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Administrator extends Employee {
    // Attributs spécifiques d'un administrateur
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="admin_role")
    private String adminRole;


}
