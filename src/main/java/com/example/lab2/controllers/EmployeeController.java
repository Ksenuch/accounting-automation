package com.example.lab2.controllers;

import com.example.lab2.entities.EmployeeEntity;
import com.example.lab2.models.Employee;
import com.example.lab2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employerService;

    @PostMapping("/add")
    public ResponseEntity addEmploee(@RequestBody EmployeeEntity employee) {
        try {
            System.out.println(employee);
            employerService.addEmployee(employee);
            return ResponseEntity.ok("Сотрудник сохранен");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeById(@PathVariable("id") int id) {
        try {
            Employee employee = employerService.removeEmployeeByIt(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            ArrayList<Employee> employees = employerService.getAll();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        try {
            Employee employee = employerService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
