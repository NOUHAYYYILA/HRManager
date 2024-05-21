package com.example.demo.service;

import com.example.demo.dao.entities.Administrator;
import com.example.demo.dao.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements CrudService<Administrator, Long> {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator add(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Page<Administrator> getAll(int page, int size) {
        return administratorRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Administrator getById(Long id) {
        return administratorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Administrator not found"));
    }

    @Override
    public Administrator update(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public boolean delete(Long id) {
        try {
            administratorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
