package com.example.demo.service;

import com.example.demo.dao.entities.Congé;
import com.example.demo.dao.repositories.CongéRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongéService implements CrudService<Congé, Long> {

    @Autowired
    private CongéRepository congéRepository;

    @Override
    public Congé add(Congé congé) {
        return congéRepository.save(congé);
    }

    @Override
    public Page<Congé> getAll(int page, int size) {
        return congéRepository.findAll(PageRequest.of(page, size));
    }

    public List<Congé> getAllWithoutPagination() {
        return congéRepository.findAll();
    }

    @Override
    public Congé getById(Long id) {
        return congéRepository.findById(id).orElse(null);
    }

    @Override
    public Congé update(Congé congé) {
        return congéRepository.save(congé);
    }

    @Override
    public boolean delete(Long id) {
        try {
            congéRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
