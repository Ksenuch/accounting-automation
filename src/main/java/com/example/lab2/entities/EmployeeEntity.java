package com.example.lab2.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
public class EmployeeEntity {
    @Id
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private int salary;
    private int money;
    private LocalDate lastEnroll;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeEntity() {
    }
}
