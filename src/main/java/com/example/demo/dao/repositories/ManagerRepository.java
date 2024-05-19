package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Employee;
import com.example.demo.dao.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ManagerRepository extends JpaRepository<Manager, Integer> {Page<Manager> findByNumberOfSubordinates(int numberOfSubordinates, Pageable pageable);


}



