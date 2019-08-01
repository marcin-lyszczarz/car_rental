package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Rent;

import java.util.List;

public interface RentService {
    public List<Rent> getAllRents();
    public Rent getRentById(Long id);
    public Rent addOrUpdateRents (Rent rent);
    public void deleteRent(Long id);
}
