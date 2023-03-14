package com.abdi.spring.rest.controller;


import com.abdi.spring.rest.entity.Employee;
import com.abdi.spring.rest.exception_handling.EmployeeIncorrectData;
import com.abdi.spring.rest.exception_handling.NoSuchEmployeeException;
import com.abdi.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmps() {

        List<Employee> allEmpList = employeeService.getAllEmployee();
        return allEmpList;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmpById(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id = " + id + " does not exist");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id);
        }
        employeeService.deleteEmployee(id);
        return employee;
    }








}
