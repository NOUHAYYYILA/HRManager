package com.example.demo.service;

import com.example.demo.dao.entities.Task;
import com.example.demo.dao.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements CrudService<Task, Long> {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task add(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Page<Task> getAll(int page, int size) {
        return taskRepository.findAll(PageRequest.of(page, size));
    }
    // Ajoutez une surcharge de méthode pour gérer l'appel sans paramètres de pagination
    public List<Task> getAll() {
        Page<Task> taskPage = getAll(0, 10); // Appel à la méthode getAll avec des valeurs par défaut pour la pagination
        return taskPage.getContent();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }


    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean delete(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

