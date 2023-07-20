package com.example.hw2_8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeConstantsTest {
    public static final String FIRST_NAME1 = "Ivan";
    public static final String LAST_NAME1 = "Ivanov";

    public static final String FIRST_NAME2 = "Makar";
    public static final String LAST_NAME2 = "Makarov";

    public static final String FIRST_NAME3 = "Pavel";
    public static final String LAST_NAME3 = "Pavlov";


    public static final int SALARY = 150;
    public static final int MAX_SALARY = 1000;
    public static final int MIN_SALARY = SALARY;


    public static final int DEPARTMENT_ID1 = 1;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1,DEPARTMENT_ID1,MAX_SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2,DEPARTMENT_ID1, MIN_SALARY);
    public static final Employee OTHER_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME3, LAST_NAME3,DEPARTMENT_ID2, MIN_SALARY);

    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, OTHER_DEPARTMENT_EMPLOYEE, MIN_SALARY_EMPLOYEE);

    public static final int DEPARTMENT_TOTAL_SALARY = EMPLOYEES.stream()
            .mapToInt(Employee::getSalary).sum();

    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENTS_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));


}
