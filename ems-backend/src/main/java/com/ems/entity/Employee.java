package com.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
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

    private String employeeCode;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String phone;

    private String gender;

    private LocalDate dob;

    private String department;

    private String designation;

    private Double salary;

    private LocalDate joiningDate;

    private String status;

    private String profileImage;

    @Column(updatable = false)
    private LocalDate createdAt;

    private LocalDate updatedAt;
}