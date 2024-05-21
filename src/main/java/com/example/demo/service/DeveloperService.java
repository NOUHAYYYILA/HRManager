package com.example.demo.service;

import com.example.demo.dao.entities.Developer;
import com.example.demo.dao.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService implements CrudService<Developer, Integer> {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public Developer add(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Page<Developer> getAll(int page, int size) {
        return developerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Developer getById(Integer id) {
        return developerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Developer not found"));
    }

    @Override
    public Developer update(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            developerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
