package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.Reservation;
import com.lyszczarzmarcin.portfolio.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservations(reservation);
    }

    @GetMapping
    public List<Reservation> list() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation reservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signClient")
    public Reservation signClient(@RequestParam("idClient") Long idClient,
                                  @RequestParam("idReservation") Long id,
                                  @RequestParam("idCar") Long idCar,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("startDate") LocalDate startDate,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("returnDate") LocalDate returnDate) {
        return reservationService.signClient(idClient, id, idCar, startDate, returnDate);
    }
}
