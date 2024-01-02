package com.example.MycoolApp.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //Define field for entityManager
    private EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theentityManager){
        entityManager = theentityManager;
    }

    @Override
    public List<Employee> findAll() {
        //Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class,theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee emp = entityManager.find(Employee.class,theId);

        entityManager.remove(emp);
    }
}
