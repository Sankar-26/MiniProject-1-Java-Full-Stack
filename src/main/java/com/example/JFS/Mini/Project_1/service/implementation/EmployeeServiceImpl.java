package com.example.JFS.Mini.Project_1.service.implementation;


import com.example.JFS.Mini.Project_1.dto.EmployeeDto;
import com.example.JFS.Mini.Project_1.entities.Employee;
import com.example.JFS.Mini.Project_1.exceptions.EmailAlreadyExistException;
import com.example.JFS.Mini.Project_1.repository.EmployeeRepository;
import com.example.JFS.Mini.Project_1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee saveEmployee = convertToUserEntity(employeeDto);

        Optional<Employee> existingEmployee =employeeRepository.findByEmployeeEmail(employeeDto.getEmployeeEmail());

        if(existingEmployee.isPresent()){
            throw new EmailAlreadyExistException("The Email is already existing in the database.");
        }else{
            return convertToUserDto(employeeRepository.save(saveEmployee));
        }

    }

    @Override
    public List<EmployeeDto> displayAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    private EmployeeDto convertToUserDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    private Employee convertToUserEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

}
