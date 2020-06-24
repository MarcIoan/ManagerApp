package com.management.stock.service;

import com.management.stock.model.Employee;
import com.management.stock.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    /**
     * Get all employers
     */
    public ArrayList<Employee> findAllEmployers(){
        return employeeRepository.findAllEmployers();
    }

    /**
     * Get employee by id
     */
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    /**
     * Add a new employee
     */
    public void addNewEmployee(Employee newEmployee) {
        employeeRepository.createEmployee(newEmployee);
    }

    /**
     * Delete an employee by his id
     */
    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteEmployeeById(employeeId);
    }

    /**
     * Update employee details (firstName, lastName, department)
     */
    public void updateEmployee(int employeeId, Employee employee){
        employeeRepository.updateEmployeeById(employeeId, employee);
    }

}


