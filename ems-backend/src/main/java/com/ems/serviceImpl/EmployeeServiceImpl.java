package com.ems.serviceImpl;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            return null;
        }

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setEmployeeCode(employeeDTO.getEmployeeCode());
            existingEmployee.setFirstName(employeeDTO.getFirstName());
            existingEmployee.setLastName(employeeDTO.getLastName());
            existingEmployee.setEmail(employeeDTO.getEmail());
            existingEmployee.setPhone(employeeDTO.getPhone());
            existingEmployee.setGender(employeeDTO.getGender());
            existingEmployee.setDepartment(employeeDTO.getDepartment());
            existingEmployee.setDesignation(employeeDTO.getDesignation());
            existingEmployee.setSalary(employeeDTO.getSalary());

            Employee updatedEmployee = employeeRepository.save(existingEmployee);

            return modelMapper.map(updatedEmployee, EmployeeDTO.class);
        }

        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
