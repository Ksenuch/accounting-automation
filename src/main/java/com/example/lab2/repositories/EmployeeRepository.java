package com.example.lab2.repositories;

import com.example.lab2.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    EmployeeEntity findById(int id);

    EmployeeEntity deleteById(int id);
}
