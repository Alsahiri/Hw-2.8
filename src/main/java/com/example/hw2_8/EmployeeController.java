package com.example.hw2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam int department,
                      @RequestParam int salary) {
        employeeService.addEmployee(firstName, lastName, department, salary);
        return "Сотрудник добавлен";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int department,
                         @RequestParam int salary) {
        employeeService.removeEmployee(firstName, lastName, department, salary);
        return "Сотрудник удален";
    }    @GetMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam int department,
                       @RequestParam int salary) {
        employeeService.findEmployee(firstName, lastName, department, salary);
        return "Сотрудник найден";
    }
}
