package com.ems.service;

import com.ems.entity.Department;
import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);
}