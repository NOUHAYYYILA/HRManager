package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer,Integer> {
}
