package com.cursosdedesarrollo.springbootresth2.services;

import java.util.List;
import java.util.Optional;

import com.cursosdedesarrollo.springbootresth2.domain.Employee;
import com.cursosdedesarrollo.springbootresth2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public Employee saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);

    }

    public Employee updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
