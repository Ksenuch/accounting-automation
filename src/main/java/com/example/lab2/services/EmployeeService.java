package com.example.lab2.services;

import com.example.lab2.entities.EmployeeEntity;
import com.example.lab2.models.Employee;
import com.example.lab2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Locale;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Async
    @Scheduled(fixedRate = 3000)
    public EmployeeEntity enrollSalary() {
        var employees = employeeRepository.findAll();

        LocalDate now = LocalDate.now();

        for(var employee : employees) {
            if(ChronoUnit.DAYS.between(employee.getLastEnroll(), now) == 30) {
                employee.setMoney( employee.getMoney() + employee.getSalary());
                System.out.println(employee.getMoney());
                employeeRepository.save(employee);
            }
        }
        return null;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employer) {
        return employeeRepository.save(employer);
    }

    public ArrayList<Employee> getAll() {
        var employees = employeeRepository.findAll();
        ArrayList<Employee> res = new ArrayList<Employee>();
        for(var e : employees)
            res.add(Employee.toModel(e));

        return res;
    }

    public Employee removeEmployeeByIt(int id) throws Exception {
        EmployeeEntity employee = employeeRepository.findById(id);

        if(employee == null)
            throw new Exception("ID указан неверно");

        employeeRepository.delete(employee);

        return Employee.toModel(employee);
    }

    public Employee getEmployeeById(int id) throws Exception {
        EmployeeEntity employee = employeeRepository.findById(id);

        if(employee == null)
            throw new Exception("ID указан неверно");

        return Employee.toModel(employee);
    }
}
