package com.ems.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String employeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String department;
    private String designation;
    private Double salary;
}