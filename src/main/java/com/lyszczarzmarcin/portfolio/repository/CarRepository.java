package com.lyszczarzmarcin.portfolio.repository;

import com.lyszczarzmarcin.portfolio.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
