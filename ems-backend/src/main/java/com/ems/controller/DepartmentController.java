package com.ems.controller;

import com.ems.entity.Department;
import com.ems.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "Department Deleted Successfully";
    }
}