package com.example.JFS.Mini.Project_1.controller;


import com.example.JFS.Mini.Project_1.dto.EmployeeDto;
import com.example.JFS.Mini.Project_1.entities.Employee;
import com.example.JFS.Mini.Project_1.repository.EmployeeRepository;
import com.example.JFS.Mini.Project_1.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class EmployeeController {

    public EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        EmployeeDto employeeDto =new EmployeeDto();
        model.addAttribute("employee",employeeDto);
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid
                               @ModelAttribute("employee") EmployeeDto employeeDto,
                               BindingResult result,
                               Model model){

        Optional<Employee> existingEmployee =  employeeRepository.findByEmployeeEmail(employeeDto.getEmployeeEmail());

        if(existingEmployee.isPresent()){
            result.rejectValue("employeeEmail",
                    null,
                    "The Email is already existing in the database.");
        }
        if(result.hasErrors()){
            model.addAttribute("employee",employeeDto);
            return "add-employee";
        }

        employeeService.createEmployee(employeeDto);
        return "redirect:/add-employee?success";
    }


    @GetMapping("/display-employee/delete")
    public String deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/display-employee";
    }


    @GetMapping("/display-employee")
    public String displayAllEmployee(Model model){
        List<EmployeeDto> employeeDtoList = employeeService.displayAllEmployees();
        model.addAttribute("employeeList",employeeDtoList);
        return "display-employee";
    }


}
