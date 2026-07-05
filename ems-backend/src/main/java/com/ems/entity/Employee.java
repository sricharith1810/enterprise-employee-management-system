package com.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee Code is required")
    private String employeeCode;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    @Column(unique = true)
    private String email;

    private String phone;

    private String gender;

    private LocalDate dob;

    private String department;

    private String designation;

    @NotNull(message = "Salary is required")
    private Double salary;

    private LocalDate joiningDate;

    private String status;

    private String profileImage;

    @Column(updatable = false)
    private LocalDate createdAt;

    private LocalDate updatedAt;
}