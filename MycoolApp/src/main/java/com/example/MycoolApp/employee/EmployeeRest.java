package com.example.MycoolApp.employee;

import com.example.MycoolApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRest {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRest(EmployeeService theemployeeService){
        this.employeeService=theemployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId){
        return employeeService.findById(empId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee emp){
        emp.setId(0);
        return employeeService.save(emp);
    }

    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee emp){
        return employeeService.save(emp);
    }

    @DeleteMapping("/employees/{empId}")
    public List<Employee> delete(@PathVariable int empId){
        employeeService.deleteById(empId);
        return findAll();
    }
}
