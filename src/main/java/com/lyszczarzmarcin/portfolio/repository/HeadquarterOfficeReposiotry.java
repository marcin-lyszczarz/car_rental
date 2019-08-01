package com.lyszczarzmarcin.portfolio.repository;

import com.lyszczarzmarcin.portfolio.model.HeadquarterOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadquarterOfficeReposiotry extends JpaRepository<HeadquarterOffice, Long> {
}
