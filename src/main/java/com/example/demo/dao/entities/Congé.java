package com.example.demo.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "conges")
public class Congé {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private String type; // Type de congé (vacances, maladie, etc.)

    @Column(length = 1000)
    private String commentaire; // Commentaire facultatif

    // Constructeurs, getters et setters



}

