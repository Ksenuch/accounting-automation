package com.example.lab2.models;

import com.example.lab2.entities.EmployeeEntity;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {

    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private float salary;
    private int money;
    private LocalDate lastEnroll;

    public static Employee toModel(EmployeeEntity entity) {
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setPatronymic(entity.getPatronymic());
        model.setSalary(entity.getSalary());
        model.setMoney(entity.getMoney());
        model.setLastEnroll(entity.getLastEnroll());
        return model;
    }

    public LocalDate getLastEnroll() {
        return lastEnroll;
    }

    public void setLastEnroll(LocalDate lastEnroll) {
        this.lastEnroll = lastEnroll;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
