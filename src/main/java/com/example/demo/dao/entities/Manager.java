package com.example.demo.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.scheduling.config.Task;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "manager")
@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee {
    // Attribut spécifique d'un Manager
    private int numberOfSubordinates;

    // Méthode pour attribuer une tâche à un employé
    //public void assignTask(Employee employee, Task task) {
        // Code pour attribuer une tâche à un employé
      //  System.out.println("Assigning task: " + task.getDescription() + " to employee: " + employee.getNom() + " " + employee.getPrenom());
    ///}

    // Méthode pour évaluer la performance d'un employé
    public void reviewPerformance(Employee employee) {
        // Code pour évaluer la performance d'un employé
        System.out.println("Reviewing performance of employee: " + employee.getNom() + " " + employee.getPrenom());
    }

    // Méthode pour organiser une réunion d'équipe
    public void manageTeamMeeting() {
        // Code pour organiser une réunion d'équipe
        System.out.println("Organizing team meeting");
    }
}
