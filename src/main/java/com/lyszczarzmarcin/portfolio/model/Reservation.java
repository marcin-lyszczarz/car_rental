package com.lyszczarzmarcin.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime reservedDate;

    @OneToOne
    private Client client;

    @OneToOne
    private Car car;

    private LocalDateTime resevationFrom;
    private LocalDateTime resevationTo;

    @OneToOne
    private BranchOffice rentFromOffice;

    @OneToOne
    private BranchOffice returnToOffice;

    private String price;

}
