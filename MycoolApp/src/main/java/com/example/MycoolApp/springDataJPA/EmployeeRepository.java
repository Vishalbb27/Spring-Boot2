package com.example.MycoolApp.springDataJPA;

import com.example.MycoolApp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findById(int theId);
}
