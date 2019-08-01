package com.lyszczarzmarcin.portfolio.repository;

import com.lyszczarzmarcin.portfolio.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
