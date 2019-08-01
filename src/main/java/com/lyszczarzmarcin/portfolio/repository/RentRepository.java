package com.lyszczarzmarcin.portfolio.repository;

import com.lyszczarzmarcin.portfolio.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
