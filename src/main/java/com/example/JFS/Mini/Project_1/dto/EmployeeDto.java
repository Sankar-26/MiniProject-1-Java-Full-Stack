package com.example.JFS.Mini.Project_1.dto;

import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long employeeId;


    @NotEmpty(message = "First Name should not be Empty.")
    private String employeeFirstName;

    @NotEmpty(message = "Last Name should not be Empty.")
    private String employeeLastName;

    @NotEmpty(message = "Email should not be Empty.")

    private String employeeEmail;

}
