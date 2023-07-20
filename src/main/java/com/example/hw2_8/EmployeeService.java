package com.example.hw2_8;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName, int department, int salary);

    Collection<Employee> findAll();
}
