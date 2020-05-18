package com.management.stock.service;

import com.management.stock.model.Employe;
import com.management.stock.repository.EmployeeRepository;

import java.util.ArrayList;


public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    // todo rename it to addEmployee
    public void addEmploye(String name, String lastName, String department) {
        employeeRepository.insert(name, lastName, department);
    }

    // todo remove employee
    public void removeEmploye(int id) {
        employeeRepository.deleteById(id);
    }

    // todo searchEmployeeById
    public Employe searchEmployeById(Long id) {
        return employeeRepository.selectById(id);
    }

    public ArrayList<Employe> searchAllEmploye(){
        return employeeRepository.selectAll();
    }
    public void modifyDepartment(int id, String department) {
        employeeRepository.updateByIdDepartment(id,department);
    }

    public void modifyById(Long id, Employe e){
        employeeRepository.updateById(id.intValue(),e.getName(),e.getLastName(),e.getDepartment());
    }

}


