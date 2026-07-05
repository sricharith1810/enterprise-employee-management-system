package com.ems.serviceImpl;

import com.ems.entity.Department;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        Department existing = departmentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setDepartmentName(department.getDepartmentName());
            existing.setDescription(department.getDescription());

            return departmentRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}