package com.example.MycoolApp.springDataJPA;

import com.example.MycoolApp.employee.Employee;

import com.example.MycoolApp.student.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    private EmployeeServiceDataJPA employeeService;
    @Autowired
    public EmployeeRestController(EmployeeServiceDataJPA theemployeeService){
        this.employeeService=theemployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId){

        if((empId > employeeService.findAll().size()) || (empId<0) || employeeService.findById(empId) == null){
            throw  new StudentNotFoundException("Student id not found - "+ empId);
        }
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
