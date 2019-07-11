package com.cursosdedesarrollo.springbootresth2.controllers;

//import java.util.ArrayList;
import java.util.List;

import com.cursosdedesarrollo.springbootresth2.domain.Employee;
import com.cursosdedesarrollo.springbootresth2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees
                = employeeService.retrieveEmployees();
        /*
        List<Employee> employees =new ArrayList<>();
        for (int i = 0; i>10;i++){
            employees.add(new Employee());
        }

         */
        return employees;
    }

    @PostMapping
    public Employee saveEmployee(
            @Valid @RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
        System.out.println(employee);
        return employee;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(name="id")Long id) {
        Employee employee=employeeService.getEmployee(id);
        if(employee!=null){
            return employee;
        }else{
            return new Employee();
        }

    }



    @DeleteMapping("/{employeeId}")
    public Employee deleteEmployee(
            @PathVariable(name="employeeId")Long employeeId){
        Employee employee= employeeService.getEmployee(employeeId);
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
        return employee;
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@Valid @RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        //emp.setName(employee.getName());
        if(emp != null){
            employeeService.updateEmployee(employee);
        }
        return employee;

    }

}
