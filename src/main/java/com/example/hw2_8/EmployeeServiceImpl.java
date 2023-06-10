package com.example.hw2_8;

import com.example.hw2_8.exception.EmployeeAlreadyAddedException;
import com.example.hw2_8.exception.EmployeeNotFoundException;
import com.example.hw2_8.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов", "Иван", 1, 35_000),
            new Employee("Артемов", "Артем",2, 40_000),
            new Employee("Петров", "Петр", 3, 70_000),
            new Employee("Максимов", "Максим", 1, 130_000)

    ));
    @Override
    public void addEmployee(String firstName, String lastName){
//        Employee employee = new Employee(firstName, lastName);
//        if (employees.containsKey(employee.getFullName())) {
//            throw new EmployeeAlreadyAddedException("Такой сотрудник у нас работает");
//        } else {
//            employees.put(employee.getFullName(), employee);
//        }
    }
    @Override
    public void removeEmployee(String firstName, String lastName){
//        Employee employee = new Employee(firstName, lastName);
//        if (employees.containsKey(employee.getFullName())) {
//            employees.remove(employee.getFullName());
//        } else {
//            throw new EmployeeNotFoundException("Работник не найден");
//        }
    }
    @Override
    public void findEmployee(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        if (employees.containsKey(employee.getFullName())) {
//            System.out.println("Такой сотрудник у нас работает");
//        } else {
//            throw new EmployeeNotFoundException("Работник не найден");
//        }
    }
}

