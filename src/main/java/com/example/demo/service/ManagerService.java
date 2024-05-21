package com.example.demo.service;

import com.example.demo.dao.entities.Manager;
import com.example.demo.dao.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements CrudService<Manager, Integer> {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager add(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Page<Manager> getAll(int page, int size) {
        return managerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Manager getById(Integer id) {
        return managerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Manager not found"));
    }

    @Override
    public Manager update(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            managerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
