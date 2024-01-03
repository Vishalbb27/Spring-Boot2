package com.example.MycoolApp.springDataJPA;

import com.example.MycoolApp.employee.Employee;

import java.util.List;

public interface EmployeeServiceDataJPA {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
