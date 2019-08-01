package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.ReturnCar;

import java.util.List;

public interface ReturnCarService {
    public List<ReturnCar> getAllReturnCars();
    public ReturnCar getReturnCarById(Long ig);
    public ReturnCar addOrUpdateReturnCar(ReturnCar returnCar);
    public void deleteReturnCar(Long id);
}
