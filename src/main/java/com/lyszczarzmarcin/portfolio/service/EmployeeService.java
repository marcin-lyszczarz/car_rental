package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployes();
    public Employee getEmployeeById(Long id);
    public Employee addEmployees(Employee employee);
    public void deleteEmployee(Long id);
    public Employee updateEmployees(Employee employee, Long id);
    public void changerBranch(Long id, Long newBranchId);
}
