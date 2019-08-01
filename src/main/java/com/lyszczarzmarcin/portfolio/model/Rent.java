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
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee rentEmployee;

    private LocalDateTime rentDate;

    @OneToOne
    private Reservation rentReservation;

    private String content;


    public Rent(Employee rentEmployee, LocalDateTime rentDate, Reservation rentReservation, String content) {
        this.rentEmployee = rentEmployee;
        this.rentDate = rentDate;
        this.rentReservation = rentReservation;
        this.content = content;
    }

}
