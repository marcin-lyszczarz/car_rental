package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Employee;
import com.lyszczarzmarcin.portfolio.repository.BranchOfficeRepository;
import com.lyszczarzmarcin.portfolio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Override
    public List<Employee> getAllEmployes() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee addEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployees(Employee employee, Long id) {
        Optional<Employee> editEmployeeOptional = employeeRepository.findById(id);

        Employee editEmployee = editEmployeeOptional.get();

        if (employee.getEmplFirstName() != null)
            editEmployee.setEmplFirstName(employee.getEmplFirstName());
        if (employee.getEmplLastName() != null)
            editEmployee.setEmplLastName(employee.getEmplLastName());
        return employeeRepository.save(employee);
    }

    @Override
    public void changerBranch(Long id, Long newBranchId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()){
            throw new EntityNotFoundException("Nie znaleziono pracownika w bazie danych");
        }
        Employee employee = optionalEmployee.get();
        BranchOffice newBranchOffice = branchOfficeRepository.getOne(newBranchId);

        employee.setEmplBranchOffice(newBranchOffice);
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
