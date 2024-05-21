package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Congé;
import com.example.demo.dao.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CongéRepository extends JpaRepository<Congé, Long> {
    Page<Congé> findByEmployee(Employee employee, Pageable pageable);
}
