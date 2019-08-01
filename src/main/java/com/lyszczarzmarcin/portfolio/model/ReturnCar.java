package com.lyszczarzmarcin.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReturnCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee returnEmployee;

    private LocalDateTime returnDate;

    @OneToOne
    private Reservation returnReservation;

    private String supplement;
    private String content;

    public ReturnCar(Employee returnEmployee, LocalDateTime returnDate, Reservation returnReservation, String supplement, String content) {
        this.returnEmployee = returnEmployee;
        this.returnDate = returnDate;
        this.returnReservation = returnReservation;
        this.supplement = supplement;
        this.content = content;
    }
}
