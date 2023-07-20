package com.example.hw2_8;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Collection<Employee> sortEmployeeByDepartment(int departmentId);

    Employee findEmployeeWithMaxSalary(int departmentId);

    Employee findEmployeeWithMinSalary(int departmentId);

    Map<Integer, List<Employee>> findEmployeesByDepartment();

    Integer getDepartmentSalarySum(int departmentId);
}
