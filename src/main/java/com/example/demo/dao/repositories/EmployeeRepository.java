package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

Page<Employee>findEmployeeByNom(String keyword,Pageable pageable);

}
