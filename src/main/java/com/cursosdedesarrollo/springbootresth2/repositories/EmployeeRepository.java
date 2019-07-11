package com.cursosdedesarrollo.springbootresth2.repositories;

import com.cursosdedesarrollo.springbootresth2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee,Long> {

}