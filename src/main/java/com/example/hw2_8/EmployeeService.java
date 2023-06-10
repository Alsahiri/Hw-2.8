package com.example.hw2_8;

import org.springframework.stereotype.Service;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);
}
