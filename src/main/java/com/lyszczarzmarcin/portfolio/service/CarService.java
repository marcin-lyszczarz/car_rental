package com.lyszczarzmarcin.portfolio.service;


import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.DTO.PartialCarDTO;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();
    public Car getCarById(Long id);
    public Car addCars(Car car);
    public void deletaCar(Long id);
    public void changeBranch(Long id, Long newBranchId);
    public void updateCarParameter(Long id, PartialCarDTO partialCarDTO);
}
