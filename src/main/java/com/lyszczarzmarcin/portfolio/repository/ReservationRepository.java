package com.lyszczarzmarcin.portfolio.repository;

import com.lyszczarzmarcin.portfolio.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
