package com.management.stock.service;

import com.management.stock.model.Employee;
import com.management.stock.repository.EmployeeRepository;

import java.util.ArrayList;


public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    /**
     * This method will returns all employers from databases
     */
    public ArrayList<Employee> findAllEmployers(){
        return employeeRepository.selectAll();
    }

    /**
     * Get employee by id
     */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.selectById(id);
    }

    /**
     * This method will add a new employee in database
     */
    public void addNewEmployee(String name, String lastName, String department) {
        employeeRepository.insert(name, lastName, department);
    }

    /**
     * Delete an employee by his id
     */
    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    /**
     *
     */
    public void updateEmployee(int employeeId, Employee employee){
        employeeRepository.updateById(employeeId, e.getName(),e.getLastName(),e.getDepartment());
    }

}


