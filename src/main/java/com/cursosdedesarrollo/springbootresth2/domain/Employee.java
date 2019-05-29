package com.cursosdedesarrollo.springbootresth2.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="EMPLOYEE")
@Data
/*
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
 */
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMPLOYEE_NAME")
    @NotBlank
    private String name;

    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    @Column(name="DEPARTMENT")
    private String department;



}