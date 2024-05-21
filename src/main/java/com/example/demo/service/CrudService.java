package com.example.demo.service;

import org.springframework.data.domain.Page;
import java.io.Serializable;


public interface CrudService<T, ID extends Serializable> {
    T add(T entity);
    Page<T> getAll(int page, int size);
    T getById(ID id);
    T update(T entity);
    boolean delete(ID id);
}

