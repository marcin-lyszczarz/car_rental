package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Employee;
import com.lyszczarzmarcin.portfolio.model.ReturnCar;
import com.lyszczarzmarcin.portfolio.service.BranchOfficeService;
import com.lyszczarzmarcin.portfolio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    BranchOfficeService branchOfficeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployees(employee);
    }

    @GetMapping
    public List<Employee> list() {
        List<Employee> employeeList = employeeService.getAllEmployes();
        return employeeList;
    }

    @GetMapping("/{id]")
    public Employee employeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/{branchId}")
    public void editedBranchOfEmployee(@PathVariable Long id, @PathVariable Long branchId) {
        employeeService.changerBranch(id, branchId);
    }

    @PutMapping("/{id}")
    public Employee editInfoEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployees( employee, id);
    }

}
