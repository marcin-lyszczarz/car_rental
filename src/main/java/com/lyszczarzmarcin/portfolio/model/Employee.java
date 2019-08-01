package com.lyszczarzmarcin.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lyszczarzmarcin.portfolio.model.enums.EmployeeStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emplFirstName;
    private String emplLastName;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @JsonIgnore
    @OneToOne
    private BranchOffice emplBranchOffice;


    public Employee(String emplFirstName, String emplLastName, EmployeeStatus employeeStatus, BranchOffice emplBranchOffice) {
        this.emplFirstName = emplFirstName;
        this.emplLastName = emplLastName;
        this.employeeStatus = employeeStatus;
        this.emplBranchOffice = emplBranchOffice;
    }
}
