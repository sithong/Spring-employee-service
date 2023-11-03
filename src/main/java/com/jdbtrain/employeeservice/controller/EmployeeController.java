package com.jdbtrain.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbtrain.employeeservice.Model.Employee;
import com.jdbtrain.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    // logger
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployee() {
        logger.info("EMployee Was Call");
        return employeeService.findAllEmployee();
    }

    // find memployee by id

    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    // add new

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);

    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, 
    @RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    // @PutMapping
    // public Employee updatEmployee(@PathVariable Integer id, Employee employee){
    // return employeeService.updateEmployee(employee.getId(), employee);
    // }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // find by departid
    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable Integer departmentId) {
        logger.info("Call Employee by departId");
        return employeeService.findEmployeeByDepartmentId(departmentId);

    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findEmployeeByorganizationId(@PathVariable Integer organizationId) {
        logger.info("Call Employee by oraganiza");
        return employeeService.finEmployeesByorganizeId(organizationId);

    }

}