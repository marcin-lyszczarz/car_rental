package com.lyszczarzmarcin.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lyszczarzmarcin.portfolio.model.enums.CarStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String body;
    private String year;
    private String color;
    private String distance;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private String price;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private BranchOffice carBranchOffice;


    public Car(String brand, String model, String body, String year, String color, String distance, CarStatus status, String price) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.year = year;
        this.color = color;
        this.distance = distance;
        this.status = status;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id;
    }
}
