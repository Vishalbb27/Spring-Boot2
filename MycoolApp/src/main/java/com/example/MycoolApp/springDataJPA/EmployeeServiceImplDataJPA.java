package com.example.MycoolApp.springDataJPA;

import com.example.MycoolApp.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplDataJPA implements EmployeeServiceDataJPA {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplDataJPA(EmployeeRepository theEmployeeRepo){
        employeeRepository = theEmployeeRepo;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeRepository.findById(theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
