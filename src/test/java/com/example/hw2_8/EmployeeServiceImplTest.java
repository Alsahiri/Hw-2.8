package com.example.hw2_8;

import com.example.hw2_8.exception.EmployeeAlreadyAddedException;
import com.example.hw2_8.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.hw2_8.EmployeeConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeValidationService);

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        assertFalse(employeeService.findAll().contains(employee));

        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        assertEquals(employee, addedEmployee);
        assertTrue(employeeService.findAll().contains(employee));
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    public void shouldThrowEmployeeAlreadyException() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        assertEquals(addedEmployee, employeeService.findEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertEquals(0,employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY));
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);

        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertEquals(1, employeeService.findAll().size());

        Employee removedEmployee = employeeService.removeEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        assertEquals(addedEmployee, removedEmployee);
        assertFalse(employeeService.findAll().contains(addedEmployee));
        assertEquals(0, employeeService.findAll().size());
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionRemove() {
        assertEquals(0,employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY));
    }

    @Test
    public void shouldReturnAllEmployee() {
        Employee employee1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID1, SALARY);
        Employee employee2= employeeService.addEmployee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID2, SALARY);

        Collection<Employee> addedEmployees = employeeService.findAll();

        assertIterableEquals(List.of(employee1,employee2),addedEmployees);
        ;
    }
}