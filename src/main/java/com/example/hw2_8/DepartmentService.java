package com.example.hw2_8;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Collection<Employee> sortEmployeeByDepartment(int departmentId);

    Optional<Employee> findEmployeeWithMaxSalary(int departmentId);

    Optional<Employee> findEmployeeWithMinSalary(int departmentId);

    Map<Integer, List<Employee>> findEmployeeByDepartment();
}
