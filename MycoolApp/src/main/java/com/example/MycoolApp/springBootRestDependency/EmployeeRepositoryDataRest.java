package com.example.MycoolApp.springBootRestDependency;

import com.example.MycoolApp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepositoryDataRest extends JpaRepository<Employee,Integer> {

    Employee findById(int theId);
}
