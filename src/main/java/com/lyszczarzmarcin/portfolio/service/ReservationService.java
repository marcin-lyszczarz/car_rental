package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    public List<Reservation> getAllReservations();
    public Reservation getReservationById(Long id);
    public Reservation addReservations(Reservation reservation);
    public void deleteReservation(Long id);
    Reservation signClient(Long idClient, Long id, Long idCar, LocalDate startDate, LocalDate returnDate);

}
