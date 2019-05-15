package com.cursosdedesarrollo.springbootresth2.services;

import com.cursosdedesarrollo.springbootresth2.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> retrieveEmployees();

    public Employee getEmployee(Long employeeId);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

    public Employee updateEmployee(Employee employee);
}
