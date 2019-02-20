package com.cursosdedesarrollo.springbootresth2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @PostMapping
    public Employee saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
        System.out.println(employee);
        return employee;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }



    @DeleteMapping("/{employeeId}")
    public Employee deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        Employee employee= employeeService.getEmployee(employeeId);
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
        return employee;
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
        }
        return employee;

    }

}
