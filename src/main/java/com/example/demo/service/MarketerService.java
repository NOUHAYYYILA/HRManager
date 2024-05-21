package com.example.demo.service;

import com.example.demo.dao.entities.Marketer;
import com.example.demo.dao.repositories.MarketerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MarketerService implements CrudService<Marketer, Integer> {

    @Autowired
    private MarketerRepository marketerRepository;

    @Override
    public Marketer add(Marketer marketer) {
        return marketerRepository.save(marketer);
    }

    @Override
    public Page<Marketer> getAll(int page, int size) {
        return marketerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Marketer getById(Integer id) {
        return marketerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Marketer not found"));
    }

    @Override
    public Marketer update(Marketer marketer) {
        return marketerRepository.save(marketer);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            marketerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
