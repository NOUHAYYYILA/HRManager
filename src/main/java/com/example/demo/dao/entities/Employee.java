package com.example.demo.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@DiscriminatorValue("user")


public  class Employee extends Administrator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotEmpty
    @Size(max = 100)
    private String nom;
    @NotEmpty
    private String prenom;
    @NotEmpty
    private String position;
    @NotEmpty
    private String adress;

}











