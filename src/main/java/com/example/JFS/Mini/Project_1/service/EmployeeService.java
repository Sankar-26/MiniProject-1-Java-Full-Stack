package com.example.JFS.Mini.Project_1.service;

import com.example.JFS.Mini.Project_1.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> displayAllEmployees();

    void deleteEmployee(Long id);

}
