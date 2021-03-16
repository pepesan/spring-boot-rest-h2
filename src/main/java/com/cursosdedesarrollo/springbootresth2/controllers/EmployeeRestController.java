package com.cursosdedesarrollo.springbootresth2.controllers;

//import java.util.ArrayList;
import java.util.List;

import com.cursosdedesarrollo.springbootresth2.domain.Employee;
import com.cursosdedesarrollo.springbootresth2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
    URLS de acceso
    Clase: Define la url base para un recurso
    Peticion : JSON
    Respuesta: code 200 -> JSON
    List: Get / -> List<Item>
    Create: Post / (item) -> Item
    Read: Get /{id} (id) -> Item
    Update: Post/Put/Patch /{id} (id, item) -> Item
    Delete: Delete /{id} (id) -> Item
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    //List
    @GetMapping
    public List<Employee> getEmployees() {
        // al definir el valor que devuelve la función
        // es toy diciendo que datos deben ser serializados
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
    // Create
    @PostMapping
    public Employee saveEmployee(
            @Valid @RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
        System.out.println(employee);
        return employee;
    }
    //Show/Read
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(name="id")Long id) {
        Employee employee=employeeService.getEmployee(id);
        if(employee!=null){
            return employee;
        }else{
            return new Employee();
        }

    }


    // Delete
    @DeleteMapping("/{id}")
    public Employee deleteEmployee(
            @PathVariable(name="id")Long employeeId){
        Employee employee= employeeService.getEmployee(employeeId);
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
        return employee;
    }

    // Update
    @PutMapping("/{id}")
    public Employee updateEmployee(@Valid @RequestBody Employee employee,
                               @PathVariable(name="id")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        //emp.setName(employee.getName());
        if(emp != null){
            employeeService.updateEmployee(employee);
        }
        return employee;

    }

}
