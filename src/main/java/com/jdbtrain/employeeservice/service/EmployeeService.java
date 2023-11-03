package com.jdbtrain.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbtrain.employeeservice.Model.Employee;
import com.jdbtrain.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    // find by Id
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // add
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // IT Project Status Updated 01 Oct 2017.pptx
    public Employee updateEmployee(int id, Employee updateEmployee) {
        if (employeeRepository.existsById(id)) {
            updateEmployee.setId(id);
            return employeeRepository.save(updateEmployee);

        } else {
            throw new RuntimeException("Employee not found for id:" + id);
        }
    }

    // delete

    public void deleteEmployee(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found for id:" + id);
        }
    }

    // find by departmentid
    public List<Employee> findEmployeeByDepartmentId(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);

    }

    // find by Organizetid
    public List<Employee> finEmployeesByorganizeId(Integer organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }

}
