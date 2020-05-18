package com.management.stock.api;

import com.management.stock.model.Employe;
import com.management.stock.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeController {
    private EmployeeService employeeService ;

   public  EmployeController(){
       employeeService = new EmployeeService();
   }

    @GetMapping("/employers")
    public ArrayList<Employe> getEmploye(){

       return employeeService.searchAllEmploye();
    }

    @PutMapping("/employers/{id}")
    public void putEmploye(@PathVariable Long id, @RequestBody Employe e){
       employeeService.modifyById(id,e);
    }

    @PostMapping("/employers")
    public void postEmploye(@RequestBody Employe e){
       employeeService.addEmploye(e.getName(),e.getLastName(),e.getDepartment());
    }
    @DeleteMapping("/employers/{id}")
    public void deleteEmploye(@PathVariable Long id){
       employeeService.removeEmploye(id.intValue());
    }

    @GetMapping("/employers/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
      return employeeService.searchEmployeById(id);
    }

}
