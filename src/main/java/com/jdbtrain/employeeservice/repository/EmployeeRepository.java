package com.jdbtrain.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdbtrain.employeeservice.Model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
    List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByOrganizationId(Integer organizationId);

}
