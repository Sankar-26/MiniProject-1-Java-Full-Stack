package com.example.JFS.Mini.Project_1.repository;

import com.example.JFS.Mini.Project_1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmployeeEmail(String email);
}
