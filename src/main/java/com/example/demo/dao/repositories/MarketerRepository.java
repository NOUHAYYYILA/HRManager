package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Marketer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketerRepository extends JpaRepository<Marketer,Integer> {
}
