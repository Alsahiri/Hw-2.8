package com.example.hw2_8;

import com.example.hw2_8.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.hw2_8.EmployeeConstantsTest.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @Test
    public void shouldReturnDepartmentSalarySum() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DEPARTMENT_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID1));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMinSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID1));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMaxSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeesByDepartment() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES, departmentService.sortEmployeeByDepartment(DEPARTMENT_ID1));
        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE),departmentService.sortEmployeeByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENTS_MAP, departmentService.findEmployeesByDepartment());
    }
    @Test
    public void shouldReturnEmptyMapWhenFindAllEmployees() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(), departmentService.findEmployeesByDepartment());
    }
}