package com.lyszczarzmarcin.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String adress;

    @OneToMany(mappedBy = "emplBranchOffice")
    private List<Employee> employees= new ArrayList<>();


    @OneToMany(mappedBy = "carBranchOffice")
    private List<Car> cars = new ArrayList<>();

    @ManyToOne
    private HeadquarterOffice headquarterOffice;

    public BranchOffice(String city, String adress, List<Employee> employees, List<Car> cars) {
        this.city = city;
        this.adress = adress;
        this.employees = employees;
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "BranchOffice{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", adress='" + adress + '\'' +
                ", employees=" + employees +
                ", cars=" + cars +
                ", headquarterOffice=" + headquarterOffice +
                '}';
    }
}
