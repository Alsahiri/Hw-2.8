package com.example.hw2_8;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }
@Override
    public Collection<Employee> sortEmployeeByDepartment(int departmentId) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .sorted(comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }
@Override
    public Optional<Employee> findEmployeeWithMaxSalary(int departmentId) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(comparingInt(Employee::getSalary));
    }
@Override
    public Optional<Employee> findEmployeeWithMinSalary(int departmentId) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(comparingInt(Employee::getSalary));
    }
@Override
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return employeeServiceImpl.employees.stream()
                .sorted(comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartment));
    }
}
