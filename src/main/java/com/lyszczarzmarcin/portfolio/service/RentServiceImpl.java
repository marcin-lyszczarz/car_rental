package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Rent;
import com.lyszczarzmarcin.portfolio.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;


    @Override
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(Long id) {
        return rentRepository.findById(id).get();
    }

    @Override
    public Rent addOrUpdateRents(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
