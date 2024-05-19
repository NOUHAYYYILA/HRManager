package com.example.demo.service;

import com.example.demo.dao.entities.Employee;
import com.example.demo.dao.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        // Validation des données
        if (employee == null || !isValidEmployee(employee)) {
            throw new IllegalArgumentException("Invalid employee data");
        }
        return employeeRepository.save(employee);
    }

    public Page<Employee> getAllEmployees(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> searchEmployee(String keyword, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findEmployeeByNom(keyword, pageable);
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        throw new IllegalArgumentException("Employee not found with ID: " + id);
    }

    public Employee updateEmployee(Employee employee) {
        if (employee == null || !isValidEmployee(employee)) {
            throw new IllegalArgumentException("Invalid employee data");
        }
        // Vérifier si l'employé existe
        Integer id = employee.getId();
        if (id == null || !employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("Employee not found with ID: " + id);
        }
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(Integer id) {
        // Vérifier si l'employé existe
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("Employee not found with ID: " + id);
        }
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            // Gestion des exceptions
            return false;
        }
    }

    private boolean isValidEmployee(Employee employee) {
        // Logique de validation des données
        // Exemple : Vérifier que les champs obligatoires sont remplis
        return employee.getNom() != null && !employee.getNom().isEmpty() &&
                employee.getPrenom() != null && !employee.getPrenom().isEmpty() &&
                employee.getPosition() != null && !employee.getPosition().isEmpty() &&
                employee.getAdress() != null && !employee.getAdress().isEmpty();
    }
}
