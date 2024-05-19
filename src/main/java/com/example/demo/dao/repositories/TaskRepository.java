package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire pour gérer les opérations spécifiques sur les tâches
}


