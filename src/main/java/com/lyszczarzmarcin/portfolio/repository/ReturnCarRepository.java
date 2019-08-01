package com.lyszczarzmarcin.portfolio.repository;


import com.lyszczarzmarcin.portfolio.model.ReturnCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnCarRepository extends JpaRepository<ReturnCar, Long> {
}
