package com.example.demo.service;

import com.example.demo.dao.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeManager {

        public  Employee addEmployee(Employee employee);
        public Page<Employee> getAllEmployees(int page, int taille);
        public Page<Employee> searchEmployee(String keyword, int page, int taille);
        public List<Employee> getByKeyword(String keyword);
        public Employee getEmployeeById(Integer id);
        public Employee updateEmployee(Employee employee);
        public boolean deleteEmployee(Integer id);
    }

