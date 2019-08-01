package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.ReturnCar;
import com.lyszczarzmarcin.portfolio.model.enums.CarStatus;
import com.lyszczarzmarcin.portfolio.repository.CarRepository;
import com.lyszczarzmarcin.portfolio.repository.ReturnCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnCarServiceImpl implements ReturnCarService {

    @Autowired
    ReturnCarRepository returnCarRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<ReturnCar> getAllReturnCars() {
        return returnCarRepository.findAll();
    }

    @Override
    public ReturnCar getReturnCarById(Long id) {
        return returnCarRepository.findById(id).get();
    }

    @Override
    public ReturnCar addOrUpdateReturnCar(ReturnCar returnCar) {
        return returnCarRepository.save(returnCar);
    }

    @Override
    public void deleteReturnCar(Long id) {
        returnCarRepository.deleteById(id);
    }
}
