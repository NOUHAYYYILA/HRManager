package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByAdminRole(String adminRole);
}

